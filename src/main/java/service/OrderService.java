package service;

import adapter.AdapterOrder;
import entity.CustomerEntity;
import entity.OrderItemsEntity;
import entity.OrderEntity;
import entity.dto.ItemDTO;
import entity.dto.OrderDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class OrderService {
    @PersistenceContext
    private EntityManager em;

    @Inject
    AdapterOrder adapterOrder;

    @Inject
    CustomerService customerService;

    public OrderItemsEntity buscarPorId(Long id) {
        return em.find(OrderItemsEntity.class, id);
    }

    @Transactional
    public OrderItemsEntity atualizar(OrderItemsEntity order) {
        em.merge(order);
        return buscarPorId(order.getId());
    }

    @Transactional
    public List<OrderItemsEntity> saveOrder(OrderDTO orderDTO) {
        CustomerEntity customer = customerService.findById(orderDTO.getCustomerId()).orElseThrow();
        List<OrderItemsEntity> orders = adapterOrder.getOrder(orderDTO, customer);
        OrderEntity orderEntity = getOrderItemEntity(customer, orderDTO.getPaymentTransaction());
        for (OrderItemsEntity order : orders) {
            order.setIdOrder(orderEntity);
            order.setTotal(order.getTotal().multiply(BigDecimal.valueOf(order.getQuantity())));
            em.persist(order);
            orderEntity.setTotal(
                    orderEntity.getTotal()
                            .add(order.getPrice()
                                    .multiply(BigDecimal.valueOf(order.getQuantity()))));
        }
        return orders;
    }

    public List<ItemDTO> getOrderItemsByOrderId(Long orderId) {
        TypedQuery<OrderItemsEntity> query = em.createQuery(
                "SELECT oi FROM OrderItemsEntity oi WHERE oi.idOrder.id = :orderId", OrderItemsEntity.class);
        query.setParameter("orderId", orderId);

        List<OrderItemsEntity> orderItemsEntities = query.getResultList();
        List<ItemDTO> itemDTOList = new ArrayList<>();

        for (OrderItemsEntity orderItemsEntity : orderItemsEntities) {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setOrderId(orderId);
            itemDTO.setQuantity(orderItemsEntity.getQuantity());
            itemDTO.setPrice(orderItemsEntity.getPrice());
            itemDTO.setProductId(orderItemsEntity.getProductName());
            itemDTOList.add(itemDTO);
        }

        return itemDTOList;
    }


    private OrderEntity getOrderItemEntity(CustomerEntity customer, String payment) {
        OrderEntity order = new OrderEntity();
        order.setIdCustomer(customer);
        order.setPaymentTransaction(payment);
        order.setOrderDate(LocalDateTime.now());
        em.persist(order);
        return order;
    }


}
