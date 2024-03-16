package entity;

import jakarta.persistence.*;

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

    @Column
    private String price;



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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



}
