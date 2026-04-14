package com.daelim.backand01.domain.entity;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class SnackEntity extends BaseEntity{
    private String name;
    private String info;
    private String manufacturer;
    private Long price;
    private Long weight;
}
