package br.com.radio.management.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.radio.management.api.domain.service.CustomerService;
import br.com.radio.management.api.dto.Customer.CustomerRequestDTO;
import br.com.radio.management.api.dto.Customer.CustomerResponseDTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService CustomerService;

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAll() {

        return ResponseEntity.ok(CustomerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getById(@PathVariable Long id) {

        return ResponseEntity.ok(CustomerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> register(@RequestBody CustomerRequestDTO costCenter) {

        return new ResponseEntity<>(CustomerService.register(costCenter), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> update(@PathVariable Long id ,@RequestBody CustomerRequestDTO costCenter) {

        return new ResponseEntity<>(CustomerService.updateById(id,costCenter), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        CustomerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
