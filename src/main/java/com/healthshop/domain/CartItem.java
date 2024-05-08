package com.healthshop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_item")
@Getter @Setter
public class CartItem {

    // TODO: 연관관계 매핑

    @Id @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    @Column(nullable = false)
    private Integer quantity = 1;

    @Column(nullable = false)
    private Long price;

}
