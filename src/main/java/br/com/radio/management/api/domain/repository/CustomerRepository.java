package br.com.radio.management.api.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.radio.management.api.domain.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    public Customer findByName(String nameCustomer);
    
}
