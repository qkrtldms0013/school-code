package com.daelim.backand01.controller;


import com.daelim.backand01.domain.dto.stock.CreateStockReqDto;
import com.daelim.backand01.domain.dto.stock.StockResDto;
import com.daelim.backand01.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @PostMapping("/create-stock")
    public Long createStock(@RequestBody CreateStockReqDto createStockReqDto) {
        return stockService.createStock(createStockReqDto);
    }
    @GetMapping("/get-stoock-list")
    public List<StockResDto> getStockList() {
        return stockService.getStockList();
    }
}
