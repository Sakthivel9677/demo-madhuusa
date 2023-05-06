package com.bezkoder.spring.datajpa.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="productDetails")

public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="productName")
    private String productName;

    @Column(name="price")
    private int  price;
    @Column(name="currency")
    private String currency;
    @Column(name="discountApplied")
    private String discountsApplied;

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDiscountsApplied() {
        return discountsApplied;
    }

    public void setDiscountsApplied(String discountsApplied) {
        this.discountsApplied = discountsApplied;
    }

    public Product(long id, String productName, int price, String currency, String discountsApplied) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.currency = currency;
        this.discountsApplied = discountsApplied;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", discountsApplied='" + discountsApplied + '\'' +
                '}';
    }
}