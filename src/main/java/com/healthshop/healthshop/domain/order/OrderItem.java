package com.healthshop.healthshop.domain.order;

import com.healthshop.healthshop.domain.item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Long price;  // 제품 하나 가격으로 간주
                         // TODO: 여기서 저장하지 말고 Item에서 바로 받아올지 추후 고민 필요

    //==비즈니스 로직==//
    /**
     * 주문 취소
     */
    public void cancel() {
        getItem().addStock(quantity);
    }

}
