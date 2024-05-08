package com.healthshop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Category {

    // TODO: 연관관계 매핑

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

}
