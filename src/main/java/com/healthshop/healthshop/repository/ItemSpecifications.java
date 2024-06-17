package com.healthshop.healthshop.repository;

import com.healthshop.healthshop.domain.item.Item;
import org.springframework.data.jpa.domain.Specification;

public class ItemSpecifications {

    public static Specification<Item> hasKeyword(String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%" + keyword + "%");
    }

    // 낮은 가격순
    public static Specification<Item> sortByPriceDesc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("price")));
            return null;
        };
    }

    // 높은 가격순
    public static Specification<Item> sortByPriceAsc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("price")));
            return null;
        };
    }

    // 할인율순
    public static Specification<Item> sortByDiscountRateDesc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("discountRate")));
            return null;
        };
    }

    // 추가순 (id 높은순)
    public static Specification<Item> sortByIdDesc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("id")));
            return null;
        };
    }
}
