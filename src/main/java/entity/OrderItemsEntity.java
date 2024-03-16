package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private CustomerEntity idCustomer;

    @ManyToOne(cascade = CascadeType.ALL)
    private OrderEntity idOrder;

    @Column
    private String productName;

    @Column
    private int quantity;

    private BigDecimal price = BigDecimal.ZERO;

    private BigDecimal total = BigDecimal.ZERO;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerEntity getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(CustomerEntity idCustomer) {
        this.idCustomer = idCustomer;
    }

    public OrderEntity getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(OrderEntity idOrderItem) {
        this.idOrder = idOrderItem;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
