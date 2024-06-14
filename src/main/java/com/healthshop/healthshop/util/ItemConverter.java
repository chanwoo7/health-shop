package com.healthshop.healthshop.util;

import com.healthshop.healthshop.controller.dto.ItemDto;
import com.healthshop.healthshop.domain.item.Category;
import com.healthshop.healthshop.domain.item.Item;

import java.text.NumberFormat;
import java.util.Locale;

public class ItemConverter {

    // Item -> ItemDto 변환
    public static ItemDto toDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());

        if (item.getCategory() != null) {
            itemDto.setCategory(item.getCategory().getName());
        }

        itemDto.setName(item.getName());

        itemDto.setPrice(item.getPrice());

        itemDto.setDiscountRate(item.getDiscountRate());
        itemDto.setBrand(item.getBrand());
        itemDto.setImgPath(item.getImgPath());
        itemDto.setDescription(item.getDescription());
        itemDto.setStockQuantity(item.getStockQuantity());

        return itemDto;
    }

    // ItemDto -> Item 변환
    public static Item toEntity(ItemDto itemDto, Category category) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setCategory(category);
        item.setName(itemDto.getName());

        // 콤마 제거하여 정수로 변환
//        try {
//            String priceWithoutCommas = itemDto.getPrice().replace(",", "");
//            item.setPrice(Integer.parseInt(priceWithoutCommas));
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("Invalid price format");
//        }

        item.setPrice(itemDto.getPrice());
        item.setDiscountRate(itemDto.getDiscountRate());
        item.setBrand(itemDto.getBrand());
        item.setImgPath(itemDto.getImgPath());
        item.setDescription(itemDto.getDescription());
        item.setStockQuantity(itemDto.getStockQuantity());

        return item;
    }
}
