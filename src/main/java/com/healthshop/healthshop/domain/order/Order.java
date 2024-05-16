package com.healthshop.healthshop.domain.order;

import com.healthshop.healthshop.domain.member.Member;
import com.healthshop.healthshop.domain.order.delivery.DeliveryAddress;
import com.healthshop.healthshop.domain.order.delivery.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private DeliveryAddress deliveryAddress;

    @Column(nullable = false)
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;  // 주문 상태: COMPLETE, CANCEL

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod payment;  // 결제 수단: CREDIT_CARD, ACCOUNT_TRANSFER

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    //==연관관계 편의 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        deliveryAddress.setOrder(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    //==생성 메서드==//
    public static Order createOrder(Member member, DeliveryAddress deliveryAddress, PaymentMethod payment, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.setDeliveryAddress(deliveryAddress);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setDate(LocalDateTime.now());
        order.setStatus(OrderStatus.COMPLETE);
        order.setPayment(payment);
        return order;
    }

    //==비즈니스 로직==//
    /**
     * 주문 취소
     */
    public void cancel() {
        if (deliveryAddress.getStatus() == DeliveryStatus.COMPLETE) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }

        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }

    //==조회 로직==//
    /**
     * 전체 주문 가격 조회
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }

}
