package com.daelim.backand01.service;


import com.daelim.backand01.domain.dto.diary.CreateDiaryReqDto;
import com.daelim.backand01.domain.dto.diary.DiaryResDto;
import com.daelim.backand01.domain.entity.Diary;
import com.daelim.backand01.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;

    public String createDiary(CreateDiaryReqDto reqDto) {
        Diary diary = new Diary();
        diary.setTitle(reqDto.title());
        diary.setContent(reqDto.content());
        diary.setDiaryDate(reqDto.diaryDate());
        diary.setEmotion(reqDto.emotion());
        diary.setWeather(reqDto.weather());

        diaryRepository.save(diary);

        return"성공함";
    }

    @Transactional
    public Long updateDiary(Long id, CreateDiaryReqDto reqDto) {
        Diary diary= diaryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 일기가 없습니다. id=" + id)
        );

        diary.setTitle(reqDto.title());
        diary.setContent(reqDto.content());
        diary.setDiaryDate(reqDto.diaryDate());
        diary.setEmotion(reqDto.emotion());
        diary.setWeather(reqDto.weather());

        return diary.getId();
    }

    @Transactional(readOnly = true)
    public List<DiaryResDto> getAllDiary() {
        return diaryRepository.findAll()
                .stream()
                .map(DiaryResDto::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<DiaryResDto> getDiaryMonthly(@RequestParam int year, @RequestParam int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());


        return diaryRepository.findByDiaryDateBetween(startDate, endDate)
                .stream()
                .map(DiaryResDto::from)
                .toList();

    }
}
