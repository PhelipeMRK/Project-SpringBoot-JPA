package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;

@Service //Registra a classe como componente de serviço do Spring, permitindo a injeção com Autowired
//pode-se usar @Component para componente genericos, @Repository para componentes repositórios, etc
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();}
		
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
		
}

