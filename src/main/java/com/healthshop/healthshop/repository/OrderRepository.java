package com.healthshop.healthshop.repository;

import com.healthshop.healthshop.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // TODO: 검색 기능 구현
}