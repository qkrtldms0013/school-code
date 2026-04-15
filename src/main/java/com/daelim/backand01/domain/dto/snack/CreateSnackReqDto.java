package com.daelim.backand01.domain.dto.snack;




public record CreateSnackReqDto(
        String name,
        String info,
        String manufacturer,
        Long price,
        Long weight
) {}
