package com.daelim.backand01.domain.dto.stock;

import com.daelim.backand01.domain.dto.store.StoreResDto;
import com.daelim.backand01.domain.entity.Stock;

public record StockResDto(Long stockId, Long snackId, Long storeId, String snackName, String storeName, Long quantity) {
    public static StockResDto from(Stock stock) {
        return new StockResDto(
                stock.getId(),
                stock.getSnack().getId(),
                stock.getStore().getId(),
                stock.getSnack().getName(),
                stock.getStore().getName(),
                stock.getQuantity()
        );
    }
}
