package com.daelim.backand01.domain.dto.store;

import com.daelim.backand01.domain.entity.Store;

import java.time.LocalDateTime;

public record StoreResDto(Long id, String name, String location, LocalDateTime createdAt) {
    public static StoreResDto from(Store entity) {
        return new StoreResDto(entity.getId(), entity.getName(), entity.getLocation(), entity.getCreatedAt());
    }
}
