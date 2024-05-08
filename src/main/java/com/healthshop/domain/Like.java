package com.healthshop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Like {

    // TODO: 연관관계 매핑

    @Id @GeneratedValue
    @Column(name = "like_id")
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

}
