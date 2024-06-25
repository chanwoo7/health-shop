package com.healthshop.healthshop.domain.member.like;

import com.healthshop.healthshop.domain.item.Item;
import com.healthshop.healthshop.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "likes")
@Getter @Setter
public class Like {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(nullable = false)
    private LocalDateTime date;

    //==연관관계 편의 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getLikes().add(this);
    }

}
