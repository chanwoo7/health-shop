package com.healthshop.healthshop.repository;

import com.healthshop.healthshop.domain.item.Item;
import org.springframework.data.jpa.domain.Specification;

public class ItemSpecifications {

    public static Specification<Item> hasCategory(String categoryName) {
        return (root, query, criteriaBuilder) -> {
            if (categoryName.isEmpty()) {
                return criteriaBuilder.conjunction();  // 항상 참인 조건 (모든 항목 반환)
            }
            return criteriaBuilder.equal(root.get("category").get("name"), categoryName);
        };
    }

    public static Specification<Item> hasKeyword(String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%" + keyword + "%");
    }

    // 낮은 가격순 (할인율 반영)
    public static Specification<Item> sortByPriceDesc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(
                criteriaBuilder.diff(  // -
                    root.get("price"),
                    criteriaBuilder.prod(  // *
                        root.get("discountRate"),
                        criteriaBuilder.quot(  // /
                            root.get("price"), 100
                        )
                    )
                )
            ));
            return null;
        };
    }

    // 높은 가격순 (할인율 반영)
    public static Specification<Item> sortByPriceAsc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(
                criteriaBuilder.diff(  // -
                    root.get("price"),
                    criteriaBuilder.prod(  // *
                        root.get("discountRate"),
                        criteriaBuilder.quot(  // /
                            root.get("price"), 100
                        )
                    )
                )
            ));
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

    // 신상품순 (id 높은 순)
    public static Specification<Item> sortByIdDesc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("id")));
            return null;
        };
    }
}
