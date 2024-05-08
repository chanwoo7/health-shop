package com.healthshop.domain.item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Item {

    // TODO: 연관관계 매핑

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Integer discountRate = 0;

    @Column(nullable = false)
    private String brand;

    private String imgPath;

    @Column(length = 1000)
    private String description;

    private Integer stockQuantity;
}
