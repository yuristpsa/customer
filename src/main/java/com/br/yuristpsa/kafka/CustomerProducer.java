package com.br.yuristpsa.kafka;

import com.br.yuristpsa.model.Customer;
import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.hibernate.criterion.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CustomerProducer {

    @Inject @Channel("customer-out")
    Emitter<Record<String, Customer>> emitter;

    public void send(Customer customer) {
        emitter.send(Record.of(customer.getId().toString(), customer));
    }
}
