package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service //Registra a classe como componente de serviço do Spring, permitindo a injeção com Autowired
//pode-se usar @Component para componente genericos, @Repository para componentes repositórios, etc
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();}
		
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
		
}

