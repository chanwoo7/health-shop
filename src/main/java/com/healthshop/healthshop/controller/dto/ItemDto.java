package com.healthshop.healthshop.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDto {
    private Long id;

    // Category의 name을 가져와야 함
    private String category;

    private String name;

    // 천 단위마다 콤마를 추가하여 저장해야 함 (ex) 10000 -> 10,000)
    private String price;

    private Integer discountRate;

    private String brand;

    private String imgPath;

    private String description;

    private Integer stockQuantity;

}
