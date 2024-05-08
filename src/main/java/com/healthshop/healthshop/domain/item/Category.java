package com.healthshop.healthshop.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    // OneToMany 매핑
    @OneToMany(mappedBy = "category")
    private List<Item> items = new ArrayList<>();

}
