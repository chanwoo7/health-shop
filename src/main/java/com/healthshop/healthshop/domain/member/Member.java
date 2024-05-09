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

@Entity
@Getter @Setter
public class Member {

    // TODO: 생성과 동시에 Cart, Like 엔티티 바로 생성할 경우 CASCADE 추가할 것

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 25)
    private String username;

    @Column(nullable = false, length = 25)
    private String loginId;

    @Column(length = 100)
    private String email;

    @Column(length = 11)
    private String phone;

    @Column(nullable = false)
    private LocalDateTime regDate;

    @Column(nullable = false)
    private Boolean isActive = true;

    @OneToMany(mappedBy = "member")
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private Cart cart;

}
