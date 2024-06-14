package com.healthshop.healthshop.util;

import com.healthshop.healthshop.controller.dto.ItemDto;
import com.healthshop.healthshop.domain.item.Category;
import com.healthshop.healthshop.domain.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemConverterTest {

    @Test
    public void toDtoTest() throws Exception {
        //given
        Category category = new Category();
        category.setId(1L);
        category.setName("무산소");

        Item item = new Item();
        item.setId(1L);
        item.setCategory(category);
        item.setName("덤벨");
        item.setPrice(10000);
        item.setDiscountRate(10);
        item.setBrand("찬우짐");
        item.setImgPath("/images/dumbbell.webp");
        item.setDescription("덤벨은 다용도 운동기구입니다.");
        item.setStockQuantity(100);

        //when
        ItemDto itemDto = ItemConverter.toDto(item);

        //then
        assertEquals(1L, itemDto.getId());
        assertEquals("무산소", itemDto.getCategory());
        assertEquals("덤벨", itemDto.getName());
        assertEquals(10000, itemDto.getPrice());
        assertEquals(10, itemDto.getDiscountRate());
        assertEquals("찬우짐", itemDto.getBrand());
        assertEquals("/images/dumbbell.webp", itemDto.getImgPath());
        assertEquals("덤벨은 다용도 운동기구입니다.", itemDto.getDescription());
        assertEquals(100, itemDto.getStockQuantity());
    }

    @Test
    public void toEntityTest() throws Exception {
        //given
        ItemDto itemDto = new ItemDto();
        itemDto.setId(1L);
        itemDto.setCategory("무산소");
        itemDto.setName("덤벨");
        itemDto.setPrice(10000);
        itemDto.setDiscountRate(10);
        itemDto.setBrand("찬우짐");
        itemDto.setImgPath("/images/dumbbell.webp");
        itemDto.setDescription("덤벨은 다용도 운동기구입니다.");
        itemDto.setStockQuantity(100);

        Category category = new Category();
        category.setId(1L);
        category.setName("무산소");

        //when
        Item item = ItemConverter.toEntity(itemDto, category);

        //then
        assertEquals(1L, item.getId());
        assertEquals(category, item.getCategory());
        assertEquals("덤벨", item.getName());
        assertEquals(10000, item.getPrice());
        assertEquals(10, item.getDiscountRate());
        assertEquals("찬우짐", item.getBrand());
        assertEquals("/images/dumbbell.webp", item.getImgPath());
        assertEquals("덤벨은 다용도 운동기구입니다.", item.getDescription());
        assertEquals(100, item.getStockQuantity());
    }

//    @Test
//    public void toEntityTest_InvalidPriceFormat() throws Exception {
//        //given
//        ItemDto itemDto = new ItemDto();
//        itemDto.setPrice("invalid");
//
//        Category category = new Category();
//        category.setId(1L);
//        category.setName("무산소");
//
//        //when & then
//        assertThrows(IllegalArgumentException.class, () -> {
//            ItemConverter.toEntity(itemDto, category);
//        });
//    }
}