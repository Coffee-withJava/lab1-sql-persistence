package entity.dto;

import entity.OrderEntity;
import entity.OrderItemsEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SavedOrderDTO {

    public static SavedOrderDTO of(List<OrderItemsEntity> orders){
        List<SavedItemDTO> items = SavedItemDTO.listOf(orders);
        OrderEntity firstItem = orders.getFirst().getIdOrder();
        SavedOrderDTO orderDTO = new SavedOrderDTO(
                firstItem.getId(),
                firstItem.getIdCustomer().getId(),
                firstItem.getPaymentTransaction(),
                firstItem.getOrderDate(),
                items,
                items.stream().map(SavedItemDTO::getTotal)
                        .reduce(BigDecimal.ZERO,(a,b)->a.add(b))
                );
        return orderDTO;
    }

    private Long id;
    private Long customerId;
    private String paymentTransaction;
    private List<SavedItemDTO> items;

    private LocalDateTime orderDate;
    private BigDecimal total;

    // Construtores, getters e setters

    public SavedOrderDTO() {
    }

    public SavedOrderDTO(Long id, Long customerId, String paymentTransaction,LocalDateTime orderDate, List<SavedItemDTO> items, BigDecimal total) {
        this.id = id;
        this.customerId = customerId;
        this.paymentTransaction = paymentTransaction;
        this.orderDate = orderDate;
        this.items = items;
        this.total = total;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPaymentTransaction() {
        return paymentTransaction;
    }

    public void setPaymentTransaction(String paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
    }

    public List<SavedItemDTO> getItems() {
        return items;
    }

    public void setItems(List<SavedItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "SavedOrderDTO{" +
                "customerId=" + customerId +
                ", paymentTransaction='" + paymentTransaction + '\'' +
                ", items=" + items +
                ", orderDate=" + orderDate +
                ", total=" + total +
                '}';
    }
}
