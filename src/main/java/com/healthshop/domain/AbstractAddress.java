package com.healthshop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public abstract class AbstractAddress {

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
    private String request = "문 앞에 놓아주세요.";

}
