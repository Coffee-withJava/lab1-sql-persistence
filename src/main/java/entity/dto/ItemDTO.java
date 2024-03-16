package entity.dto;

public class ItemDTO {
    private String productId;
    private Integer quantity;
    private String price;

    private Long orderId;

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public ItemDTO() {
    }

    public ItemDTO(String productId, int quantity, String price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", price='" + price + '\'' +
                '}';
    }
}
