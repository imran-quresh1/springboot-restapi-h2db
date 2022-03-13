package com.imran.customer.service;

import com.imran.customer.model.Customer;
import com.imran.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Imran", "Qureshi", "1980-01-01");
    }

    @Test
    public void givenCustomerObject_whenSaved_thenReturnSavedCustomer() {
        // given - setup mock return object
        Customer expectedCustomer = new Customer(customer.getFirstname(), customer.getLastname(), customer.getDateOfBirth());
        expectedCustomer.setId(1L);
        when(customerRepository.save(any(Customer.class))).thenReturn(expectedCustomer);

        // when
        Customer customerCreated = customerService.createCustomer(customer);

        // then
        assertThat(customerCreated).isNotNull();
        assertThat(customerCreated).isEqualTo(expectedCustomer);
    }

    @Test
    public void givenCustomerId_whenGetCustomer_thenFindAndReturnCustomerObject() {
        // given - setup mock return object
        Customer expectedCustomer = new Customer(customer.getFirstname(), customer.getLastname(), customer.getDateOfBirth());
        expectedCustomer.setId(1L);
        when(customerRepository.findById(any(Long.class))).thenReturn(Optional.of(expectedCustomer));

        // when
        Optional<Customer> customerFound = customerService.getCustomer(1L);

        // then
        assertThat(customerFound).isNotNull();
        assertThat(customerFound.get()).isEqualTo(expectedCustomer);
    }

}