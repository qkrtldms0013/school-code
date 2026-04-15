package com.daelim.backand01.service;

import com.daelim.backand01.domain.dto.store.CreateStoreReqDto;
import com.daelim.backand01.domain.dto.store.StoreResDto;
import com.daelim.backand01.domain.entity.Store;
import com.daelim.backand01.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional
    public Long createStore(CreateStoreReqDto createStoreReqDto) {
        Store store = new Store(createStoreReqDto.name(), createStoreReqDto.location());
        return storeRepository.save(store).getId();
    }

    @Transactional(readOnly = true)
    public List<StoreResDto> getStoreList() {
        return storeRepository.findAll()
                .stream()
                .map(StoreResDto::from)
                .toList();
    }
}
