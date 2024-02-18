package com.demo.app.shoppingservice.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name="tbl_invoice_items")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive
    private Double quantity;
    private Double price;

    @Column(name="product_id")
    private Long productId;

    @Transient
    private Double subTotal;

    public Double getSubTotal() {
        if(this.price>0 && this.quantity>0) {
            return this.quantity*price;
        }else {
            return (double) 0;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
