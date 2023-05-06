package com.bezkoder.spring.datajpa.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="promocodeDetails")
@Data
public class PromoCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="promocode")
    private String promocode;
    @Column(name="discount")
    private double discount;
    @Column(name="discountType")
    private String discountType;
    @Column(name="numberOfVoucher")
    private int numberOfVoucher;


}
