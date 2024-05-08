package com.healthshop.healthshop.domain.member.cart;

import com.healthshop.healthshop.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Cart {

    @Id @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private LocalDateTime date;

    // OneToMany 매핑
    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems = new ArrayList<>();

}
