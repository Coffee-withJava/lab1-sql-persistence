package entity.dto;

import entity.OrderEntity;
import entity.OrderItemsEntity;

import java.math.BigDecimal;
import java.util.List;

public class SavedItemDTO {
    private String productId;
    private Integer quantity;
    private BigDecimal price;

    private BigDecimal total;

    public static List<SavedItemDTO> listOf(List<OrderItemsEntity> orders) {
        return orders.stream().map(item->
                new SavedItemDTO(item.getProductName(),
                        item.getQuantity(), item.getPrice(),item.getTotal())).toList();
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public SavedItemDTO() {
    }

    public SavedItemDTO(String productId, int quantity, BigDecimal price, BigDecimal total) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SavedItemDTO{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", price='" + price + '\'' +
                '}';
    }
}
