package com.bezkoder.spring.datajpa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="subscriptionDetails")
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="subscriptionName")
    private String subscriptionName;
    @Column(name="price")
    private double price;
    @Column(name="currency")
    private String currency;
    @Column(name="susbscriptionType")
    private String subscriptionType;
    @Column(name="validity")
    private String validity;

}
