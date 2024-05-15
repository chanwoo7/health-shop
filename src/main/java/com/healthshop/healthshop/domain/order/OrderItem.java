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
    private Integer price;  // 제품 하나 가격

    //==생성 메서드==//
    public static OrderItem createOrderItem(Item item, int price, int quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setPrice(price);
        orderItem.setQuantity(quantity);
        item.removeStock(quantity);
        return orderItem;
    }

    //==비즈니스 로직==//
    /**
     * 주문상품 취소
     */
    public void cancel() {
        getItem().addStock(quantity);
    }

    /**
     * 주문상품 전체 가격 조회
     */
    public int getTotalPrice() {
        return getPrice() * getQuantity();
    }

}
