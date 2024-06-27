package com.healthshop.healthshop.service;

import com.healthshop.healthshop.domain.item.Category;
import com.healthshop.healthshop.domain.item.Item;
import com.healthshop.healthshop.repository.CategoryRepository;
import com.healthshop.healthshop.repository.ItemRepository;
import com.healthshop.healthshop.repository.ItemSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Page<Item> findItems(String keyword, String sort, PageRequest pageRequest) {
        // 주어진 키워드로 Item의 name 필드 검색하는 조건 생성
        Specification<Item> spec = Specification.where(ItemSpecifications.hasKeyword(keyword));

        spec = switch (sort) {
            case "priceDesc" -> spec.and(ItemSpecifications.sortByPriceDesc());
            case "priceAsc" -> spec.and(ItemSpecifications.sortByPriceAsc());
            case "discountRateDesc" -> spec.and(ItemSpecifications.sortByDiscountRateDesc());
            case "idDesc" -> spec.and(ItemSpecifications.sortByIdDesc());
            default -> spec;
        };

        return itemRepository.findAll(spec, pageRequest);
    }

    @Transactional
    public void setItemCategoryById(Long itemId, Long categoryId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() ->
                new IllegalArgumentException("Invalid item Id: " + itemId));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->
                new IllegalArgumentException("Invalid category Id: " + categoryId));
        item.setCategory(category);
        itemRepository.save(item);
    }
}
