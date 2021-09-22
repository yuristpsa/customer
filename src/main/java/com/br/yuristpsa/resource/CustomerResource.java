package com.br.yuristpsa.resource;

import com.br.yuristpsa.model.Customer;
import com.br.yuristpsa.service.CustomerService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customers")
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @POST
    public Response create(Customer customer) {
        Customer customerEntity = this.customerService.save(customer);
        return Response.status(Response.Status.OK).entity(customerEntity).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Customer customer) {
        Customer customerUpdated = this.customerService.update(id, customer);
        return Response.status(Response.Status.OK).entity(customerUpdated).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        this.customerService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    public List<Customer> list() {
        return this.customerService.list();
    }

    @GET
    @Path("{id}")
    public Customer findById(@PathParam("id") Long id) {
        return this.customerService.findById(id);
    }
}
