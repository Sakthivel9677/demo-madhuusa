package com.bezkoder.spring.datajpa.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="purchaseProduct")
@Data
public class PurchaseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int custId;
    private String customerProduct;
    private String customerSubscription;
    private LocalDate subscriptionDate;
    private String promoCode;
    public PurchaseProduct(){}
}
