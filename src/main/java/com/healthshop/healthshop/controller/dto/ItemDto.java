package com.healthshop.healthshop.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDto {
    private Long id;

    // Category의 name을 가져와야 함
    private String category;

    private String name;

    private Integer price;

    private Integer discountRate;

    private String brand;

    private String imgPath;

    private String description;

    private Integer stockQuantity;

}
