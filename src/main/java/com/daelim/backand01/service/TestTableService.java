package com.daelim.backand01.service;

import com.daelim.backand01.domain.dto.testTable.CreateTestTableReqDto;
import com.daelim.backand01.domain.dto.testTable.TestTableResDto;
import com.daelim.backand01.domain.entity.TestTable;
import com.daelim.backand01.repository.TestTableRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.SimpleTimeZone;

@Service
@RequiredArgsConstructor
public class TestTableService {
    private final TestTableRepository testTableRepository;
    
    public String createTestTable(String title, String content) {
        TestTable testTable = new TestTable();
        testTable.setTitle(title);
        testTable.setContent(content);

        testTableRepository.save(testTable);

        return "테스트 테이블 생성됨";
    }

    public TestTableResDto getTestTableById(Long id) {
        TestTable testTable = testTableRepository.findByIdAndDeletedFalse(id).orElse(null);

        if(testTable == null) {
            return null;
        }
        return TestTableResDto.from(testTable);
    }

    public List<TestTableResDto> getTestTableList() {
        List<TestTable> testTableList =testTableRepository.findByDeletedFalse();
        List<TestTableResDto> testTableResDtoList = new ArrayList<>();

//        for(int i = 0; i < testTableList.size(); i++) {
//            TestTable entity = testTableList.get(i);
//            TestTableResDto testTableResDto = TestTableResDto.from(entity);
//            testTableResDtoList.add(testTableResDto);
//        }

        for(TestTable entity : testTableList) {
            testTableResDtoList.add(TestTableResDto.from(entity));
        }
        return testTableResDtoList;
    }

    public List<TestTableResDto> getTestTableListByTitle(String title) {
        List<TestTable> testTableList = testTableRepository.findByTitleAndDeletedFalse(title);

        return testTableList.stream()
                .map(TestTableResDto::from)
                .toList();

    }

    public List<TestTableResDto> getTestTableListByKeyword(String title) {

        return testTableRepository.findByTitleContainingOrContentContainingAndDeletedFalse(title, title)
                .stream()
                .map(TestTableResDto::from)
                .toList();

    }

    @Transactional
    public String updateTestTable(Long id, CreateTestTableReqDto createTestTableReqDto) {
        TestTable testTable = testTableRepository.findById(id).orElse(null);

        if(testTable == null) {
            return "잘못된 ID 입니다.";
        }

        testTable.setTitle(createTestTableReqDto.getTitle());
        testTable.setContent(createTestTableReqDto.getContent());

        return "수정하기 성공";
    }

    public String deleteTestTable(Long id) {
        TestTable testTable = testTableRepository.findById(id).orElse(null);

        if(testTable == null) {
            return "잘못된 ID 입니다.";
        }

//        testTableRepository.delete(testTable); hard delete
        testTable.delete();

        return "하드 딜리트로 진짜 지웠음";
    }

}
