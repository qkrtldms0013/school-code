package com.daelim.backand01.domain.dto.snack;

import com.daelim.backand01.domain.entity.SnackEntity;
import lombok.Data;

@Data
public class SnackResDto {
    private Long id;
    private String name;
    private String info;
    private String manufacturer;
    private Long price;
    private Long weight;

    public static SnackResDto from(SnackEntity snack) {
        SnackResDto dto = new SnackResDto();
        dto.setId(snack.getId());
        dto.setName(snack.getName());
        dto.setInfo(snack.getInfo());
        dto.setManufacturer(snack.getManufacturer());
        dto.setPrice(snack.getPrice());
        dto.setWeight(snack.getWeight());
        return dto;
    }
}