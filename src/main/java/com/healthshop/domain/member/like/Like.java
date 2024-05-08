package com.healthshop.domain.member.like;

import com.healthshop.domain.item.Item;
import com.healthshop.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Like {

    @Id @GeneratedValue
    @Column(name = "like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(nullable = false)
    private LocalDateTime date;

}
