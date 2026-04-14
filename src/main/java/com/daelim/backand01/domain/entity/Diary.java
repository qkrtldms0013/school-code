package com.daelim.backand01.domain.entity;


import com.daelim.backand01.domain.dto.diary.Emotion;
import com.daelim.backand01.domain.dto.diary.Weather;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Diary extends BaseEntity{

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "Text")
    private String content;

    @Column(nullable = false)
    private LocalDate diaryDate; //일기 작성 일자(사용자가 선택함)

    @Enumerated(EnumType.STRING)
    private Emotion emotion;

    @Enumerated(EnumType.STRING)
    private Weather weather;

}
