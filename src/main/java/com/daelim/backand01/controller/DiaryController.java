package com.daelim.backand01.controller;


import com.daelim.backand01.domain.dto.diary.CreateDiaryReqDto;
import com.daelim.backand01.domain.dto.diary.DiaryResDto;
import com.daelim.backand01.repository.DiaryRepository;
import com.daelim.backand01.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping("/create-diary")
    public String createDiary(@RequestBody CreateDiaryReqDto createDiaryReqDto) {
        return diaryService.createDiary(createDiaryReqDto);
    }

    @PostMapping("/update-diary/{id}")
    public Long updateDiary(@PathVariable Long id, @RequestBody CreateDiaryReqDto createDiaryReqDto) {
        return diaryService.updateDiary(id, createDiaryReqDto);
    }

    @GetMapping("/get-all-diary")
    public List<DiaryResDto> getAllDiary() {
        return diaryService.getAllDiary();
    }

    @GetMapping("/get-diary-monthly")
    public List<DiaryResDto> getDiaryMonthly(@RequestParam int year, @RequestParam int month){
        return diaryService.getDiaryMonthly(year, month);
    }

}
