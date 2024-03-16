package controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.CustomerService;

@Path("/customer")
public class CustomerController {
    @Inject
    CustomerService customerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object salvar(Object customer) {
        return customerService.save(customer);
    }

    @GET
    @Path("/{id}")
    public Object getOrderService(@PathParam("id") Long id) {
        return customerService.findById(id);
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        customerService.delete(id);
        return Response.ok("ORDER DELETED").build();
    }

    @PUT
    public Object atualizar(Object customer) {
        return customerService.update(customer);
    }
}
