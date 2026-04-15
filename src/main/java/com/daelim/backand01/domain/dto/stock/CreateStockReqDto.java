package com.daelim.backand01.domain.dto.stock;

public record CreateStockReqDto(
    Long storeId, Long snackId, Long quantity
) {
}
