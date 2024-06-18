package com.healthshop.healthshop.service;

import com.healthshop.healthshop.domain.item.Item;
import com.healthshop.healthshop.domain.member.Member;
import com.healthshop.healthshop.domain.order.Order;
import com.healthshop.healthshop.domain.order.OrderStatus;
import com.healthshop.healthshop.domain.order.PaymentMethod;
import com.healthshop.healthshop.exception.NoDefaultAddressException;
import com.healthshop.healthshop.exception.NotEnoughStockException;
import com.healthshop.healthshop.repository.OrderRepository;
import com.healthshop.healthshop.service.dto.ItemQuantity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired EntityManager em;
    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;

    // 통합 테스트 방식으로 작성

    @Test
    public void 단일상품주문() throws Exception {
        //given
        Member member = createMember();
        Item dumbbell = createItem("덤벨", 10000, "㈜한국짐", 500);

        ItemQuantity iq = new ItemQuantity(dumbbell.getId(), 2);

        List<ItemQuantity> itemQuantities = new ArrayList<>();
        itemQuantities.add(iq);

        PaymentMethod payment = PaymentMethod.ACCOUNT_TRANSFER;

        //when
        Long orderId = orderService.order(member.getId(), itemQuantities, payment);

        //then
        Order getOrder = orderRepository.findById(orderId).orElse(null);

        // 1. 상품 주문 시 상태는 COMPLETE
        assertEquals(OrderStatus.COMPLETE, getOrder.getStatus());
        // 2. 주문한 상품 종류 수가 정확해야 한다.
        assertEquals(1, getOrder.getOrderItems().size());
        // 3. 주문 가격은 가격 * 수량이다.
        assertEquals(10000 * 2, getOrder.getTotalPrice());
        // 4. 주문 수량만큼 재고가 줄어야 한다.
        assertEquals(500 - 2, dumbbell.getStockQuantity());
    }

    @Test
    public void 여러상품주문() throws Exception {
        //given
        Member member = createMember();
        Item dumbbell = createItem("덤벨", 10000, "㈜한국짐", 500);
        Item gloves = createItem("장갑", 8000, "㈜우리짐", 100);

        ItemQuantity iq1 = new ItemQuantity(dumbbell.getId(), 2);
        ItemQuantity iq2 = new ItemQuantity(gloves.getId(), 3);

        List<ItemQuantity> itemQuantities = new ArrayList<>();
        itemQuantities.add(iq1);
        itemQuantities.add(iq2);

        PaymentMethod payment = PaymentMethod.ACCOUNT_TRANSFER;

        //when
        Long orderId = orderService.order(member.getId(), itemQuantities, payment);

        //then
        Order getOrder = orderRepository.findById(orderId).orElse(null);

        // 1. 상품 주문 시 상태는 COMPLETE
        assertEquals(OrderStatus.COMPLETE, getOrder.getStatus());
        // 2. 주문한 상품 종류 수가 정확해야 한다.
        assertEquals(2, getOrder.getOrderItems().size());
        // 3. 주문 가격은 각 상품의 (가격 * 수량)을 더한 값이다.
        assertEquals(10000 * 2 + 8000 * 3, getOrder.getTotalPrice());
        // 4. 주문 수량만큼 재고가 줄어야 한다.
        assertEquals(500 - 2, dumbbell.getStockQuantity());
        assertEquals(100 - 3, gloves.getStockQuantity());
    }

    @Test
    public void 상품주문_재고수량초과() throws Exception {
        //given
        Member member = createMember();
        Item dumbbell = createItem("덤벨", 10000, "㈜한국짐", 10);

        ItemQuantity iq = new ItemQuantity(dumbbell.getId(), 11);

        List<ItemQuantity> itemQuantities = new ArrayList<>();
        itemQuantities.add(iq);

        PaymentMethod payment = PaymentMethod.ACCOUNT_TRANSFER;

        //when
        Assertions.assertThrows(NotEnoughStockException.class,
                () -> orderService.order(member.getId(), itemQuantities, payment));
    }

    @Test
    public void 상품주문_기본주소미설정() throws Exception {
        //given
        Member member = createNoAddressMember();

        Item dumbbell = createItem("덤벨", 10000, "㈜한국짐", 500);
        ItemQuantity iq = new ItemQuantity(dumbbell.getId(), 2);

        List<ItemQuantity> itemQuantities = new ArrayList<>();
        itemQuantities.add(iq);

        PaymentMethod payment = PaymentMethod.ACCOUNT_TRANSFER;

        //when
        Assertions.assertThrows(NoDefaultAddressException.class,
                () -> orderService.order(member.getId(), itemQuantities, payment));
    }

    @Test
    public void 주문취소() throws Exception {
        //given
        Member member = createMember();

        Item dumbbell = createItem("덤벨", 10000, "㈜한국짐", 500);
        ItemQuantity iq = new ItemQuantity(dumbbell.getId(), 2);

        List<ItemQuantity> itemQuantities = new ArrayList<>();
        itemQuantities.add(iq);

        PaymentMethod payment = PaymentMethod.ACCOUNT_TRANSFER;

        Long orderId = orderService.order(member.getId(), itemQuantities, payment);

        //when
        orderService.cancelOrder(orderId);

        //then
        Order getOrder = orderRepository.findById(orderId).orElse(null);

        // 1. 주문 취소 시 상태는 CANCEL
        assertEquals(OrderStatus.CANCEL, getOrder.getStatus());
        // 2. 취소된 수량만큼 재고가 증가해야 한다.
        assertEquals(500, dumbbell.getStockQuantity());
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.createAddress("서울특별시 중구 세종대로 110",
                "한국아파트 1000동 1000호",
                "10000",
                "김철수",
                "010-0000-0000",
                "문 앞에 놓아주세요.");
        member.setLoginId("example123");
        member.setPassword("example123");
        member.setRegDate(LocalDateTime.now());
        em.persist(member);
        return member;
    }

    private Member createNoAddressMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setLoginId("example123");
        member.setPassword("example123");
        member.setRegDate(LocalDateTime.now());
        em.persist(member);
        return member;
    }

    // TODO: Item 클래스에 생성 메서드 따로 만들지 고민할 것
    private Item createItem(String name, int price, String brand, int stockQuantity) {
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setBrand(brand);
        item.setStockQuantity(stockQuantity);
        em.persist(item);
        return item;
    }

}