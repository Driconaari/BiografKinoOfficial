package com.example.biografkinoofficial.repository;


import com.example.biografkinoofficial.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
