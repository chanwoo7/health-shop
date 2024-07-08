package com.healthshop.healthshop.controller.form;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class ItemForm {
    private Long itemId;

    @NotBlank(message = "상품명은 필수 입력값입니다.")
    private String name;

    private Long categoryId;

    @NotNull(message = "상품 가격은 필수 입력값입니다.")
    private Integer price;

    @NotNull(message = "할인율은 필수 입력값입니다.")
    @Min(value = 0, message = "할인율은 0 이상 100 미만의 정수값이어야 합니다.")
    @Max(value = 99, message = "할인율은 0 이상 100 미만의 정수값이어야 합니다.")
    private Integer discountRate;

    @NotBlank(message = "브랜드명은 필수 입력값입니다.")
    private String brand;

    private String imgPath;

    private MultipartFile imgFile;

    @NotBlank(message = "상품 설명은 필수 입력값입니다.")
    private String description;

    @NotNull(message = "재고수량은 필수 입력값입니다.")
    @Min(value = 0, message = "재고수량은 양수값이어야 합니다.")
    private Integer stockQuantity;

}
