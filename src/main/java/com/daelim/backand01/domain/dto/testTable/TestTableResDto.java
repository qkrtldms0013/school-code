package com.daelim.backand01.domain.dto.testTable;

import com.daelim.backand01.domain.entity.TestTable;

import java.time.LocalDateTime;

public record TestTableResDto(
        Long id,
        LocalDateTime createdAt,
        String title,
        String content,
        Long count
) {
    public static TestTableResDto from(TestTable entity) {
        return new TestTableResDto(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getTitle(),
                entity.getContent(),
                entity.getCount()
        );
    }

}
