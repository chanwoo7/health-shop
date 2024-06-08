package com.healthshop.healthshop.domain.member;

import com.healthshop.healthshop.domain.member.cart.Cart;
import com.healthshop.healthshop.domain.member.like.Like;
import com.healthshop.healthshop.domain.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false, length = 25, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(length = 100)
    private String email;

    @Column(length = 11)
    private String phone;

    @Column(nullable = false)
    private LocalDateTime regDate;

    @Column(nullable = false)
    private Boolean isActive = true;

    @OneToMany(mappedBy = "member")
    private List<MemberAddress> memberAddresses = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cart cart;

    //==생성 메서드==//
    /**
     * 회원 주소 생성
     */
    // TODO: 메서드 파라미터가 많으므로, 추후 빌더 패턴 고려할 것
    public MemberAddress createAddress(String addressMain,
                                       String addressDetail,
                                       String zipcode,
                                       String name,
                                       String phone,
                                       String request) {
        MemberAddress memberAddress = new MemberAddress();
        memberAddress.setMember(this);
        memberAddress.setAddressMain(addressMain);
        memberAddress.setAddressDetail(addressDetail);
        memberAddress.setZipcode(zipcode);
        memberAddress.setName(name);
        memberAddress.setPhone(phone);
        memberAddress.setRequest(request);
        memberAddress.setIsDefault(this.getDefaultAddress().isEmpty());
        this.memberAddresses.add(memberAddress);
        return memberAddress;
    }

    //==조회 로직==//
    /**
     * 기본 주소 조회
     */
    public Optional<MemberAddress> getDefaultAddress() {
        return memberAddresses.stream()
                .filter(MemberAddress::getIsDefault) // isDefault가 true인 Address만 필터링
                .findFirst();
    }

}
