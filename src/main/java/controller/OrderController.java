package controller;

import entity.OrderItemsEntity;
import entity.dto.ItemDTO;
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
    public OrderItemsEntity getOrderService(@PathParam("id") Long id) {
        return orderService.buscarPorId(id);
    }

    @PUT
    public OrderItemsEntity atualizar(OrderItemsEntity order) {
        return orderService.atualizar(order);
    }

    @POST
    @Path("/saveOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OrderDTO saveOrder(OrderDTO order) {
        return orderService.saveOrder(order);
    }


    @GET
    @Path("/{orderId}/items")
    public List<ItemDTO> getOrderItemsByOrderId(@PathParam("orderId") Long orderId) {
        return orderService.getOrderItemsByOrderId(orderId);
    }

}
