package com.healthshop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    // TODO: 연관관계 매핑

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

}
