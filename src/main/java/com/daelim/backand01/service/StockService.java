package com.daelim.backand01.service;


import com.daelim.backand01.domain.dto.stock.CreateStockReqDto;
import com.daelim.backand01.domain.dto.stock.StockResDto;
import com.daelim.backand01.domain.dto.store.StoreResDto;
import com.daelim.backand01.domain.entity.Snack;
import com.daelim.backand01.domain.entity.Stock;
import com.daelim.backand01.domain.entity.Store;
import com.daelim.backand01.repository.SnackRepository;
import com.daelim.backand01.repository.StockRepository;
import com.daelim.backand01.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    private final SnackRepository snackRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Long createStock(CreateStockReqDto createStockReqDto) {
        Snack snack = snackRepository.findById(createStockReqDto.snackId()).orElseThrow(
                () -> new IllegalArgumentException("Snack Id: " + createStockReqDto.snackId() + " not Found")
        );

        Store store = storeRepository.findById(createStockReqDto.storeId()).orElseThrow(
                () -> new IllegalArgumentException("Store Id: " + createStockReqDto.storeId() + " not Found")
        );

        Stock stock = new Stock(snack, store, createStockReqDto.quantity());
        stockRepository.save(stock);

        return stock.getId();
    }

    @Transactional(readOnly = true)
    public List<StockResDto> getStockList() {
        return stockRepository.findAll().stream().map(StockResDto::from).toList();
    }
}
