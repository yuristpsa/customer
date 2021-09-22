package com.br.yuristpsa.repository;

import com.br.yuristpsa.model.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    @Transactional
    public Customer save(Customer customer) {
        persist(customer);
        return customer;
    }

    @Transactional
    public Customer update(Long id, Customer customer) {
        Customer customerEntity = findById(id);

        customerEntity.setName(customer.getName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setDocument(customer.getDocument());
        persist(customerEntity);
        return customerEntity;
    }

    @Transactional
    public void delete(Long id) {
        Customer customerEntity = findById(id);
        delete(customerEntity);
    }

}
