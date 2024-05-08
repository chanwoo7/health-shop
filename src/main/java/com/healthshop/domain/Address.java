package com.healthshop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Address {

    // TODO: 연관관계 매핑

    @Id @GeneratedValue
    @Column(name = "address_id")
    private Long id;

    @Column(nullable = false)
    private Boolean isDefault = false;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 100)
    private String addressDetail;

    @Column(nullable = false, length = 5)
    private String zipcode;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false, length = 11)
    private String phone;

    @Column(length = 100)
    private String request;
}
