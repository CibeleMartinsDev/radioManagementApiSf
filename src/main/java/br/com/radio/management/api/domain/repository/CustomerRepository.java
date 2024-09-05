package br.com.radio.management.api.domain.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.radio.management.api.domain.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    Optional<Customer> findByName(String name);
    
}
