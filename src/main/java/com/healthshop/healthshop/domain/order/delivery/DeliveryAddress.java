package com.healthshop.healthshop.domain.order.delivery;

import com.healthshop.healthshop.domain.Address;
import com.healthshop.healthshop.domain.member.MemberAddress;
import com.healthshop.healthshop.domain.order.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
public class DeliveryAddress extends Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_address_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;

    @OneToOne(mappedBy = "deliveryAddress", fetch = FetchType.LAZY)
    private Order order;

}
