package com.mftvanak.javaee.zero.eshop.domain;

import javax.persistence.*;

@Entity
@Table(name="sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="sale_date_time")
    private long saleDateTime;
    @ManyToOne
    @JoinColumn(name="buyer_id", nullable =  false)
    private User buyer;
    @ManyToOne
    @JoinColumn(name="sold_product_id", nullable = false)
    private Product soldProduct;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSaleDateTime() {
        return saleDateTime;
    }

    public void setSaleDateTime(long saleDateTime) {
        this.saleDateTime = saleDateTime;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Product getSoldProduct() {
        return soldProduct;
    }

    public void setSoldProduct(Product soldProduct) {
        this.soldProduct = soldProduct;
    }
}
