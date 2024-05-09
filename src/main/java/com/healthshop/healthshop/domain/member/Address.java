package com.healthshop.healthshop.domain.member;

import com.healthshop.healthshop.domain.AbstractAddress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Address extends AbstractAddress {

    @Id @GeneratedValue
    @Column(name = "address_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private Boolean isDefault = false;

    //==연관관계 편의 메서드==//
    public void setMember(Member member){
        this.member = member;
        member.getAddresses().add(this);
    }

}
