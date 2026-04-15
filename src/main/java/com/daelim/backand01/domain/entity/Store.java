package com.daelim.backand01.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity{

    @Column(nullable = false, length = 64)
    private String name;
    private String location;
}
