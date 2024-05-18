package com.healthshop.healthshop.service;

import com.healthshop.healthshop.domain.item.Item;
import com.healthshop.healthshop.domain.member.Member;
import com.healthshop.healthshop.domain.order.Order;
import com.healthshop.healthshop.domain.order.OrderStatus;
import com.healthshop.healthshop.domain.order.PaymentMethod;
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
        // 회원 정보 설정
        Member member = createMember();

        // 상품 정보 설정 (1개)
        Item dumbbell = createItem("덤벨", 10000, "㈜한국짐", 500);

        // 주문할 상품 및 수량 정보 설정
        ItemQuantity iq = new ItemQuantity(dumbbell.getId(), 2);

        // 리스트에 담기
        List<ItemQuantity> itemQuantities = new ArrayList<>();
        itemQuantities.add(iq);

        // 결제수단 설정
        PaymentMethod payment = PaymentMethod.ACCOUNT_TRANSFER;

        //when
        Long orderId = orderService.order(member.getId(), itemQuantities, payment);

        //then
        Order getOrder = orderRepository.findOne(orderId);

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
        // 회원 정보 설정
        Member member = createMember();

        // 상품 정보 설정 (여러 개)
        Item dumbbell = createItem("덤벨", 10000, "㈜한국짐", 500);
        Item gloves = createItem("장갑", 8000, "㈜우리짐", 100);

        // 주문할 상품 및 수량 정보 설정
        ItemQuantity iq1 = new ItemQuantity(dumbbell.getId(), 2);
        ItemQuantity iq2 = new ItemQuantity(gloves.getId(), 3);

        // 리스트에 담기
        List<ItemQuantity> itemQuantities = new ArrayList<>();
        itemQuantities.add(iq1);
        itemQuantities.add(iq2);

        // 결제수단 설정
        PaymentMethod payment = PaymentMethod.ACCOUNT_TRANSFER;

        //when
        Long orderId = orderService.order(member.getId(), itemQuantities, payment);

        //then
        Order getOrder = orderRepository.findOne(orderId);

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
        // 회원 정보 설정
        Member member = createMember();

        // 상품 정보 설정
        Item dumbbell = createItem("덤벨", 10000, "㈜한국짐", 10);

        // 주문할 상품 및 수량 정보 설정
        ItemQuantity iq = new ItemQuantity(dumbbell.getId(), 11);

        // 리스트에 담기
        List<ItemQuantity> itemQuantities = new ArrayList<>();
        itemQuantities.add(iq);

        // 결제수단 설정
        PaymentMethod payment = PaymentMethod.ACCOUNT_TRANSFER;

        //when
        Assertions.assertThrows(NotEnoughStockException.class,
                () -> orderService.order(member.getId(), itemQuantities, payment));
    }

    // TODO: 주문 취소

    // TODO: 배송지 생성

    // TODO: 배송지 생성 - 기본 주소 미설정

    // TODO: 전체 주문 가격 조회

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