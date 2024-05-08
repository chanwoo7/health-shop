package com.healthshop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Cart {

    // TODO: 연관관계 매핑

    @Id @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

}
