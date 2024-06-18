package com.healthshop.healthshop.service;

import com.healthshop.healthshop.domain.item.Item;
import com.healthshop.healthshop.domain.member.Member;
import com.healthshop.healthshop.domain.order.Order;
import com.healthshop.healthshop.domain.order.OrderItem;
import com.healthshop.healthshop.domain.order.PaymentMethod;
import com.healthshop.healthshop.domain.order.delivery.DeliveryAddress;
import com.healthshop.healthshop.exception.NoDefaultAddressException;
import com.healthshop.healthshop.repository.ItemRepository;
import com.healthshop.healthshop.repository.MemberRepository;
import com.healthshop.healthshop.repository.OrderRepository;
import com.healthshop.healthshop.service.dto.ItemQuantity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId, List<ItemQuantity> itemQuantities, PaymentMethod payment) {

        // 엔티티 조회
        Member member = memberRepository.findById(memberId).orElseThrow(() ->
                new IllegalArgumentException("Invalid member ID: " + memberId));


        // 배송정보 생성
        DeliveryAddress deliveryAddress;
        if (member.getDefaultAddress().isPresent()) {
            deliveryAddress = Order.createDeliveryAddress(member.getDefaultAddress().get());
        } else {
            throw new NoDefaultAddressException("기본 주소가 설정되어 있지 않습니다.");
        }

        // 주문상품 목록 생성
        List<OrderItem> orderItems = new ArrayList<>();
        for (ItemQuantity itemQuantity : itemQuantities) {
            Optional<Item> optionalItem = itemRepository.findById(itemQuantity.getItemId());
            if (optionalItem.isPresent()) {
                Item item = optionalItem.get();
                OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), itemQuantity.getQuantity());
                orderItems.add(orderItem);
            } else {
                // Handle the case where the item is not found
                throw new IllegalArgumentException("Item not found for id: " + itemQuantity.getItemId());
            }
        }

        // 주문상품 생성
        Order order = Order.createOrder(member, deliveryAddress, payment, orderItems.toArray(new OrderItem[0]));

        // 주문 저장
        orderRepository.save(order);

        return order.getId();

    }

    /**
     * 주문 취소
     */
    @Transactional
    public void cancelOrder(Long orderId) {
        // 주문 엔티티 조회
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new IllegalArgumentException("Invalid order ID: " + orderId));
        // 주문 취소
        order.cancel();
    }

    /**
     * TODO: 검색
     */
//    public List<Order> findOrders(OrderSearch orderSearch) {
//        return orderRepository.findAll(orderSearch);
//    }

}
