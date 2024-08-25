package br.com.personal.expenses.personalexpenses.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.personal.expenses.personalexpenses.domain.exception.ResourceNotFoundException;
import br.com.personal.expenses.personalexpenses.domain.model.Customer;
import br.com.personal.expenses.personalexpenses.domain.model.UserAdmin;
import br.com.personal.expenses.personalexpenses.domain.repository.CustomerRepository;
import br.com.personal.expenses.personalexpenses.dto.Customer.CustomerRequestDTO;
import br.com.personal.expenses.personalexpenses.dto.Customer.CustomerResponseDTO;

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

    
}
