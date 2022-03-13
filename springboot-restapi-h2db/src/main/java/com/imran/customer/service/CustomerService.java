package com.imran.customer.service;

import com.imran.customer.model.Customer;
import com.imran.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer createCustomer(final Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> getCustomer(final Long id) {
        return repository.findById(id);
    }
}
