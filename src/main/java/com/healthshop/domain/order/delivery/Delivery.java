package com.healthshop.domain.order.delivery;

import com.healthshop.domain.AbstractAddress;
import com.healthshop.domain.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery extends AbstractAddress {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;

    // OneToOne 매핑
    @OneToOne(mappedBy = "delivery")
    private Order order;

}
