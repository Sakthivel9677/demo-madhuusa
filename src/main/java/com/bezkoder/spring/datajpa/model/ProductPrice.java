package com.bezkoder.spring.datajpa.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ProductPrice {
    private String ProductName;
    private double originalPrice;
    private String appliedPromo;
    private double discount;
    private double finalPrice;

    public ProductPrice(String productName, double originalPrice, String appliedPromo, double discount, double finalPrice) {
        ProductName = productName;
        this.originalPrice = originalPrice;
        this.appliedPromo = appliedPromo;
        this.discount = discount;
        this.finalPrice = finalPrice;
    }

    public ProductPrice() {

    }

    public HttpStatus getStatusCode(){
    return HttpStatus.OK;
}
public HttpStatus getBody(){
    return HttpStatus.OK;
}
}
