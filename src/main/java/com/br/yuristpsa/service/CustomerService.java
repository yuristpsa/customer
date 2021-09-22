package com.br.yuristpsa.service;

import com.br.yuristpsa.kafka.CustomerProducer;
import com.br.yuristpsa.model.Customer;
import com.br.yuristpsa.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PathParam;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerProducer customerProducer;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerProducer customerProducer) {
        this.customerRepository = customerRepository;
        this.customerProducer = customerProducer;
    }

    public Customer save(Customer customer) {
        Customer customerEntity = this.customerRepository.save(customer);
        customerProducer.send(customerEntity);
        return customerEntity;
    }

    public Customer update(@PathParam("id") Long id, Customer customer) {
        return this.customerRepository.update(id, customer);
    }

    public void delete(Long id) {
        this.customerRepository.delete(id);
    }

    public List<Customer> list() {
        return this.customerRepository.listAll();
    }

    public Customer findById(@PathParam("id") Long id) {
        return this.customerRepository.findById(id);
    }
}
