package com.healthshop.healthshop.repository;

import com.healthshop.healthshop.domain.item.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class ItemSpecificationsTest {

    // data.sql 가져온 상태에서 테스트 실행할 것! (application.yml 수정 필요)

    @Autowired
    ItemRepository itemRepository;

    @Test
    void sortByPriceDesc() {
        Specification<Item> spec = ItemSpecifications.sortByPriceDesc();
        Page<Item> items = itemRepository.findAll(spec, PageRequest.of(0, 10));
        items.forEach(item -> System.out.println(item.getName() + ": " + (item.getPrice() - (item.getPrice() * item.getDiscountRate() / 100.0))));
    }

    @Test
    void sortByPriceAsc() {
        Specification<Item> spec = ItemSpecifications.sortByPriceAsc();
        Page<Item> items = itemRepository.findAll(spec, PageRequest.of(0, 10));
        items.forEach(item -> System.out.println(item.getName() + ": " + (item.getPrice() - (item.getPrice() * item.getDiscountRate() / 100.0))));
    }
}