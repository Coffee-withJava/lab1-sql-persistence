package adapter;

import entity.CustomerEntity;
import entity.OrderItemsEntity;
import entity.dto.OrderDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class AdapterOrder {

    public List<OrderItemsEntity> getOrder(OrderDTO orderDTO, CustomerEntity customer){
        List<OrderItemsEntity> orderItemsEntity = new ArrayList<>();
        orderDTO.getItems().forEach(dto -> {
            OrderItemsEntity entity = new OrderItemsEntity();
            entity.setIdCustomer(customer);
            entity.setQuantity(dto.getQuantity());
            entity.setPrice(dto.getPrice());
            entity.setProductName(dto.getProductId());
            orderItemsEntity.add(entity);
        });
        return orderItemsEntity;
    }


}
