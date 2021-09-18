package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Order;

//poderiamos usar @Repository para registrar como componente do Spring, porem não é necessário,
//já que "UserRepository" herda de "JpaRepository" que já é registrado
public interface OrderRepository extends JpaRepository<Order, Long>{

}
