package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.dto.CustomerRequest;
import com.course.dto.CustomerResponse;
import com.course.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/api/endpoint")
    public String getData()
    {
    	return "hellooo Customerservice";
    }

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/list")
    public List<CustomerResponse> getCustomerList() {
        return customerService.getCustomerList();
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable int id, @RequestBody CustomerRequest customerRequest) {
        return customerService.updateCustomer(id, customerRequest);
    }

    @GetMapping("/name/{name}")
    public List<CustomerResponse> getCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }

    @GetMapping("/email/{email}")
    public List<CustomerResponse> getCustomerByEmail(@PathVariable String email) {
        return customerService.getCustomerByEmail(email);
    }

    @GetMapping("/pagination")
    public Page<CustomerResponse> findCustomersWithPagination(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return customerService.findCustomersWithPagination(pageNumber, pageSize);
    }

    @GetMapping("/sort")
    public List<CustomerResponse> customerSortByField(@RequestParam String field) {
        return customerService.customerSortByField(field);
    }

    @GetMapping("/pagination-and-sort")
    public Page<CustomerResponse> findCustomersWithPaginationAndSorting(@RequestParam int pageNumber, @RequestParam int pageSize, @RequestParam String field) {
        return customerService.findCustomersWithPaginationAndSorting(pageNumber, pageSize, field);
    }
}
