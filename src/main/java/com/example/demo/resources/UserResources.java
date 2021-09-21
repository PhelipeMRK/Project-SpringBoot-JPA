package com.example.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

//Controlador Rest que responde no caminho "/users"

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);} //resposta de sucesso
	
	@GetMapping(value = "/{id}") //indica que a requisição aceitará um Id dentro da url
	public ResponseEntity<User> findById(@PathVariable Long id) //indica que o método receberá um valor da url
	{   User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);}
	
	@PostMapping //Post = Inserir recurso (Inserindo novo usuário)
	public ResponseEntity<User> insert(@RequestBody User obj){//RequestBody desserializará o objeto Json transformando em um objeto User
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
