package com.healthshop.domain.member;

import com.healthshop.domain.AbstractAddress;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Address extends AbstractAddress {

    // TODO: 연관관계 매핑

    @Id @GeneratedValue
    @Column(name = "address_id")
    private Long id;

    @Column(nullable = false)
    private Boolean isDefault = false;

}
