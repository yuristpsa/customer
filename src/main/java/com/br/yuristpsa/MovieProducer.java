package com.br.yuristpsa;

import com.br.yuristpsa.model.Customer;
import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.hibernate.criterion.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MovieProducer {

    @Inject @Channel("movies-out")
    Emitter<Record<String, Customer>> emitter;

    public void sendMovieToKafka(Customer movie) {
        emitter.send(Record.of("1", movie));
    }
}
