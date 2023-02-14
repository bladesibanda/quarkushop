package com.bladesibanda.web;

import com.bladesibanda.service.OrderItemService;
import com.bladesibanda.web.dto.OrderItemDto;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;

@Path("/order-items")
public class OrderItemResource {
    @Inject
    OrderItemService itemService;

    @GET
    @Path("/order/{id}")
    public List<OrderItemDto> findByOrderId(@PathParam("id") Long id) {
        return this.itemService.findByOrderId(id);
    }

    @GET
    @Path("/{id}")
    public OrderItemDto findByID(@PathParam("id") Long id) {
        return this.itemService.findById(id);
    }

    @POST
    public OrderItemDto create(@Valid OrderItemDto orderItemDto) {
        return this.itemService.create(orderItemDto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        this.itemService.delete(id);
    }
}
