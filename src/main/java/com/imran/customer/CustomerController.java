package com.imran.customer;

import com.imran.customer.model.Customer;
import com.imran.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

        log.info("inside createCustomer=" + customer);

        Customer createdCustomer = customerService.createCustomer(customer);

        log.info("customer created in-memory=" + createdCustomer);

        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping(path = "{customerId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {

        log.info("inside getCustomer with customerId=" + customerId);

        Optional<Customer> customer = customerService.getCustomer(Long.parseLong(customerId));

        if( customer.isPresent() ) {
            log.info("customer found from in-memory database " + customer.get());
            return new ResponseEntity<>(customer.orElseThrow(), HttpStatus.OK);
        }
        else {
            log.info("customer not found with customerId=" + customerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
