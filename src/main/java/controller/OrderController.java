package controller;

import entity.dto.OrderDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.OrderService;

import java.util.List;


@Path("/order")
public class OrderController {

    @Inject
    OrderService orderService;

    @GET
    @Path("/{id}")
    public Object getOrderService(@PathParam("id") Long id) {
        return orderService.buscarPorId(id);
    }

    @PUT
    public Object update(Object order) {
        return orderService.update(order);
    }

    @POST
    @Path("/saveOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> saveOrder(OrderDTO order) {
        return orderService.saveOrder(order);
    }


    @GET
    @Path("/{orderId}/items")
    public List<Object> getOrderItemsByOrderId(@PathParam("orderId") Long orderId) {
        return orderService.getOrderItemsByOrderId(orderId);
    }

}
