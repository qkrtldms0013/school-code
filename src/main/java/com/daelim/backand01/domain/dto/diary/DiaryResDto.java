package com.daelim.backand01.domain.dto.diary;

import com.daelim.backand01.domain.entity.Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DiaryResDto(
        String title,
        String content,
        LocalDate diaryDate,
        Emotion emotion,
        Weather weather,
        LocalDateTime updatedAt
) {
    public static DiaryResDto from(Diary diary) {
        return new DiaryResDto(
                diary.getTitle(),
                diary.getContent(),
                diary.getDiaryDate(),
                diary.getEmotion(),
                diary.getWeather(),
                diary.getUpdatedAt()
        );
    }
}
