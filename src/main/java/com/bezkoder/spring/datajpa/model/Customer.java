package com.bezkoder.spring.datajpa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="customerDetails")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int custId;

    private String name;
    private String address;
    private String gender;
    private double age;

}
