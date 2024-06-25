package com.healthshop.healthshop.domain.item;

import com.healthshop.healthshop.exception.NotEnoughStockException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer discountRate = 0;

    @Column(nullable = false)
    private String brand;

    private String imgPath;

    @Column(length = 1000)
    private String description;

    private Integer stockQuantity;

    //==비즈니스 로직==//
    /**
     * stockQuantity 증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stockQuantity 감소
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("Need more stock!");
        }
        this.stockQuantity = restStock;
    }
}
