package com.daelim.backand01.domain.dto.diary;

import java.time.LocalDate;

public record CreateDiaryReqDto(
        String title,
        String content,
        LocalDate diaryDate,
        Emotion emotion,
        Weather weather
) {
}
