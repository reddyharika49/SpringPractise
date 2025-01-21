package com.course.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.course.dto.CustomerRequest;
import com.course.dto.CustomerResponse;
import com.course.entity.Customer;
import com.course.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired 
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerResponse> getCustomerList() {
        return customerRepository.findAll().stream()
            .map(entity -> modelMapper.map(entity, CustomerResponse.class))
            .collect(Collectors.toList());
    }

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
    	Customer customer = modelMapper.map(customerRequest,Customer.class); 
    	return modelMapper.map(customerRepository.save(customer),CustomerResponse.class);
    	}


    public CustomerResponse getCustomerById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return modelMapper.map(customer.orElse(null), CustomerResponse.class);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    public CustomerResponse updateCustomer(int id, CustomerRequest newCustomerRequest) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer newCustomer = modelMapper.map(newCustomerRequest, Customer.class);
            newCustomer.setId(id);
            return modelMapper.map(customerRepository.save(newCustomer), CustomerResponse.class);
        }
        return null;
    }

    public List<CustomerResponse> getCustomerByName(String name) {
        return customerRepository.getCustomerByName(name).stream()
            .map(entity -> modelMapper.map(entity, CustomerResponse.class))
            .collect(Collectors.toList());
    }

    public List<CustomerResponse> getCustomerByEmail(String email) {
        return customerRepository.getCustomerByEmail(email).stream()
            .map(entity -> modelMapper.map(entity, CustomerResponse.class))
            .collect(Collectors.toList());
    }

    // pagination
    public Page<CustomerResponse> findCustomersWithPagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Customer> customersPage = customerRepository.findAll(pageable);
        List<CustomerResponse> CustomerResponseList = customersPage.getContent().stream()
            .map(customer -> modelMapper.map(customer, CustomerResponse.class))
            .collect(Collectors.toList());
        return new PageImpl<>(CustomerResponseList, pageable, customersPage.getTotalElements());
    }

    // sort by field
    public List<CustomerResponse> customerSortByField(String field) {
        List<Customer> customers = customerRepository.findAll(Sort.by(Sort.Direction.ASC, field));
        return customers.stream()
            .map(entity -> modelMapper.map(entity, CustomerResponse.class))
            .collect(Collectors.toList());
    }

    // pagination and sort by field
    public Page<CustomerResponse> findCustomersWithPaginationAndSorting(int pageNumber, int pageSize, String field) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(field));
        Page<Customer> customerPage = customerRepository.findAll(pageable);
        List<CustomerResponse> CustomerResponseList = customerPage.getContent().stream()
            .map(entity -> modelMapper.map(entity, CustomerResponse.class))
            .collect(Collectors.toList());
        return new PageImpl<>(CustomerResponseList, pageable, customerPage.getTotalElements());
    }
}
