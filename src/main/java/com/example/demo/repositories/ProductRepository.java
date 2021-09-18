package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Product;

//poderiamos usar @Repository para registrar como componente do Spring, porem não é necessário,
//já que "CategoryRepository" herda de "JpaRepository" que já é registrado
public interface ProductRepository extends JpaRepository<Product, Long> {

}
