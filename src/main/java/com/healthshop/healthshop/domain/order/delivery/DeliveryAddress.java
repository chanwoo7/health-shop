package com.healthshop.healthshop.domain.order.delivery;

import com.healthshop.healthshop.domain.Address;
import com.healthshop.healthshop.domain.member.MemberAddress;
import com.healthshop.healthshop.domain.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class DeliveryAddress extends Address {

    @Id @GeneratedValue
    @Column(name = "delivery_address_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;

    @OneToOne(mappedBy = "deliveryAddress", fetch = FetchType.LAZY)
    private Order order;

    //==생성 메서드==//
    /**
     * 회원 기본 주소로부터 복사
     */
    // TODO: 반복적인 코드 리팩토링 필요
    public static DeliveryAddress createDeliveryAddress(MemberAddress memberAddress) {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setStatus(DeliveryStatus.BEFORE_SHIPPING);
//        deliveryAddress.setOrder  // Order 객체 생성 후 연결할 것
        deliveryAddress.setAddressMain(memberAddress.getAddressMain());
        deliveryAddress.setAddressDetail(memberAddress.getAddressDetail());
        deliveryAddress.setZipcode(memberAddress.getZipcode());
        deliveryAddress.setName(memberAddress.getName());
        deliveryAddress.setPhone(memberAddress.getPhone());
        deliveryAddress.setRequest(memberAddress.getRequest());
        return deliveryAddress;
    }

}
