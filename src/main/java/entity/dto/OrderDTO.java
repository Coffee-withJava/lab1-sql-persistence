package entity.dto;

import java.util.List;

public class OrderDTO {
    private Long customerId;
    private String paymentTransaction;
    private List<ItemDTO> items;

    // Construtores, getters e setters

    public OrderDTO() {
    }

    public OrderDTO(Long customerId, String paymentTransaction, List<ItemDTO> items) {
        this.customerId = customerId;
        this.paymentTransaction = paymentTransaction;
        this.items = items;
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

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "customerId='" + customerId + '\'' +
                ", paymentTransaction='" + paymentTransaction + '\'' +
                ", items=" + items +
                '}';
    }
}
