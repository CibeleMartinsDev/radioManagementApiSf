package br.com.radio.management.api.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.radio.management.api.domain.exception.ResourceNotFoundException;
import br.com.radio.management.api.domain.model.Customer;
import br.com.radio.management.api.domain.model.UserAdmin;
import br.com.radio.management.api.domain.repository.CustomerRepository;
import br.com.radio.management.api.dto.Customer.CustomerRequestDTO;
import br.com.radio.management.api.dto.Customer.CustomerResponseDTO;

@Service
public class CustomerService implements CRUDService<CustomerRequestDTO, CustomerResponseDTO> {
    
    @Autowired
    private CustomerRepository CustomerRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CustomerResponseDTO> getAll() {

        UserAdmin user = (UserAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       
        List<Customer> costumerRepository = CustomerRepository.findAll();

        return costumerRepository.stream().map(Customer -> mapper.map(Customer, CustomerResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDTO getById(Long id) {
       
        Optional<Customer> CustomerModelRepository = CustomerRepository.findById(id);
        UserAdmin user = (UserAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(CustomerModelRepository.isEmpty()) {
            throw new ResourceNotFoundException("Cliente não encontrado.");
        }

        return mapper.map(CustomerModelRepository.get(), CustomerResponseDTO.class);
    }

    @Override
    public CustomerResponseDTO register(CustomerRequestDTO dto) {

        Customer CustomerModel = mapper.map(dto, Customer.class);

        // quem é o usuário que faz essa requisição
        UserAdmin user = (UserAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        CustomerModel.setId(null);

        CustomerModel = CustomerRepository.save(CustomerModel);
     
        return mapper.map(CustomerModel, CustomerResponseDTO.class);
    }

    @Override
    public CustomerResponseDTO updateById(Long id, CustomerRequestDTO dto) {

        getById(id);
        Customer CustomerModel = mapper.map(dto, Customer.class);

        UserAdmin user = (UserAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        CustomerModel.setId(id);
        CustomerModel = CustomerRepository.save(CustomerModel);
      
        return mapper.map(CustomerModel, CustomerResponseDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        
        getById(id);
        CustomerRepository.deleteById(id);
    }

    public CustomerResponseDTO getByName(String name){

        Optional<Customer> customer = CustomerRepository.findByName(name);
        UserAdmin user = (UserAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(customer.isEmpty()) {
            throw new ResourceNotFoundException("Cliente não encontrado.");
        }
        return mapper.map(customer.get(), CustomerResponseDTO.class);

    }

    
}
