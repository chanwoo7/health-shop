package com.healthshop.domain.member;

import com.healthshop.domain.AbstractAddress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Address extends AbstractAddress {

    @Id @GeneratedValue
    @Column(name = "address_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private Boolean isDefault = false;

}
