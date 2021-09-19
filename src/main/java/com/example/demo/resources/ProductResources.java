package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

//Controlador Rest que responde no caminho "/products"

@RestController
@RequestMapping(value = "/products")
public class ProductResources {
	
	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list); //resposta de sucesso
		}
	@GetMapping(value = "/{id}") //indica que a requisição aceitará um Id dentro da url
	public ResponseEntity<Product> findById(@PathVariable Long id) //indica que o método receberá um valor da url
	{   Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);}
	
	
}
