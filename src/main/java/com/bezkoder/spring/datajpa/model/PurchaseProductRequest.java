package com.bezkoder.spring.datajpa.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PurchaseProductRequest {
    private long id;
    private int custId;
    private String name;
    private String address;
    private String gender;
    private double age;
    private String productName;
    private String promocode;
    private String subscription;
    private LocalDate subscriptionDate;
    private String response;










}
