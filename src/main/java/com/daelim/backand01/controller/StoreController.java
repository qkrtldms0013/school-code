package com.daelim.backand01.controller;


import com.daelim.backand01.domain.dto.store.CreateStoreReqDto;
import com.daelim.backand01.domain.dto.store.StoreResDto;
import com.daelim.backand01.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/create-store")
    public String createStore(@RequestBody CreateStoreReqDto createStoreReqDto){
        storeService.createStore(createStoreReqDto);
        return "";
    }

    @GetMapping("/get-store-list")
    public List<StoreResDto> getStoreList() {
        return storeService.getStoreList();
    }
}
