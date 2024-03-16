package adapter;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class AdapterOrder {
    //TODO REMOVER COMENTARIOS

    /*

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

    */
}
