package com.daelim.backand01.domain.dto.snack;


import lombok.Data;

@Data
public class CreateSnackReqDto {
    private String name;
    private String info;
    private String manufacturer;
    private Long price;
    private Long weight;

}
