package com.daelim.backand01.domain.entity;


import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Snack extends BaseEntity{
    private String name;
    private String info;
    private String manufacturer;
    private Long price;
    private Long weight;

    public Snack(String name, String info, String manufacturer, Long price, Long weight) {
        this.name = name;
        this.info = info;
        this.manufacturer = manufacturer;
        this.price = price;
        this.weight = weight;

    }

    public void update(Long price, Long weight) {  // ← 추가!
        this.price = price;
        this.weight = weight;
    }
}
