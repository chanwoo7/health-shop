package com.healthshop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery extends AbstractAddress {

    // TODO: 연관관계 매핑

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;

}
