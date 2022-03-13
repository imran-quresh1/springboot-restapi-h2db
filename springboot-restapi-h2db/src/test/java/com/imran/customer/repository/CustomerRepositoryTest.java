package com.imran.customer.repository;

import com.imran.customer.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Imran", "Qureshi", "1980-01-01");
    }

    @Test
    public void givenCustomerObject_whenSaved_thenReturnSavedCustomer() {
        // given - setUp() method creates a customer object

        // when
        Customer savedCustomer = customerRepository.save(customer);

        // then
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getId()).isGreaterThan(0);
    }

    @Test
    public void givenCustomerId_whenGetCustomer_thenFindAndReturnCustomerObject() {
        // given - setUp() method creates a customer object in the in-memory database,
        // and we save that customer in the database so that we can look it up using id
        Customer savedCustomer = customerRepository.save(customer);
        Long idToLookUp = savedCustomer.getId();

        // when
        Optional<Customer> customerFound = customerRepository.findById(idToLookUp);

        // then
        assertThat(customerFound).isNotNull();
        assertThat(customerFound.orElseThrow()).isEqualTo(customer);
    }
}