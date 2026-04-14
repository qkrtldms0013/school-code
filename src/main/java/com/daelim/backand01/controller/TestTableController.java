package com.daelim.backand01.controller;

import com.daelim.backand01.domain.dto.testTable.CreateTestTableReqDto;
import com.daelim.backand01.domain.dto.testTable.TestTableResDto;
import com.daelim.backand01.service.TestTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestTableController {
    private final TestTableService testTableService;

    @PostMapping("/create-test-table")
    public String createTestTable(@RequestBody CreateTestTableReqDto createTestTableReqDto) {
        return testTableService.createTestTable(
                createTestTableReqDto.getTitle(),
                createTestTableReqDto.getContent()
        );
    }
    @GetMapping("/get-test-table-by-id/{id}")
    public TestTableResDto getTestTableById(@PathVariable Long id) {
        return testTableService.getTestTableById(id);
    }

    @GetMapping("/get-test-table-list")
    public List<TestTableResDto> getTestTableList() {
        return testTableService.getTestTableList();
    }

    @GetMapping("/get-test-table-list-by-title")
    public List<TestTableResDto> getTestTableListByTitle(@RequestParam String title) {
        return testTableService.getTestTableListByTitle(title);
    }

    @PostMapping("/update-test-table/{id}")
    public String updateTestTable(
            @PathVariable Long id,
            @RequestBody CreateTestTableReqDto createTestTableReqDto) {
        return testTableService.updateTestTable(id, createTestTableReqDto);
    }

    @PostMapping("/delete-test-table/{id}")
    public String deleteTestTable(@PathVariable Long id) {
        return testTableService.deleteTestTable(id);
    }
}
