package com.healthshop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@Getter @Setter
public class OrderItem {

    // TODO: 연관관계 매핑

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Long price;

}
