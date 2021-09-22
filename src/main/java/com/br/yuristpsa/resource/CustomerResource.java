package com.br.yuristpsa.resource;

import com.br.yuristpsa.MovieProducer;
import com.br.yuristpsa.model.Customer;
import com.br.yuristpsa.repository.CustomerRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/customers")
public class CustomerResource {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    MovieProducer producer;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Customer customer) {
        producer.sendMovieToKafka(customer);
//        kafkaProducerService.publishInvalidatedContents(customer);
 //        kafkaProducerService.publishInvalidatedContents(customer);
//        customerRepository.persist(customer);
    }

/*    @Inject
    MovieProducer producer;

    @POST
    public Response send(Movie movie) {
        producer.sendMovieToKafka(movie);
        // Return an 202 - Accepted response.
        return Response.accepted().build();
    }*/

}
