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
        Member member = memberRepository.findOne(memberId);

        // 배송정보 생성
        DeliveryAddress deliveryAddress;
        if (member.getDefaultAddress().isPresent()) {
            deliveryAddress = DeliveryAddress.createDeliveryAddress(member.getDefaultAddress().get());
        } else {
            throw new NoDefaultAddressException("기본 주소가 설정되어 있지 않습니다.");
        }

        // 주문상품 목록 생성
        List<OrderItem> orderItems = new ArrayList<>();
        for (ItemQuantity itemQuantity : itemQuantities) {
            Item item = itemRepository.findOne(itemQuantity.getItemId());
            OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), itemQuantity.getQuantity());
            orderItems.add(orderItem);
        }

        // 주문상품 생성
        Order order = Order.createOrder(member, deliveryAddress, payment, orderItems.toArray(new OrderItem[0]));

        // 주문 저장
        orderRepository.save(order);

        return order.getId();

    }

}
