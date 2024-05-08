package com.healthshop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

    // TODO: 연관관계 매핑
    // TODO: 주소 인터페이스 생성하고 Address, Delivery를 구현체로

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;

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
