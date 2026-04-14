package com.daelim.backand01.service;


import com.daelim.backand01.domain.dto.snack.SnackResDto;
import com.daelim.backand01.domain.entity.SnackEntity;
import com.daelim.backand01.domain.entity.TestTable;
import com.daelim.backand01.repository.SnackRepository;
import com.daelim.backand01.repository.TestTableRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SnackService {
    private final SnackRepository snackRepository;

    public String createSnack(String name, String info, String manufacturer, Long price, Long weight) {
        SnackEntity snackEntity = new SnackEntity();
        snackEntity.setName(name);
        snackEntity.setInfo(info);
        snackEntity.setManufacturer(manufacturer);
        snackEntity.setPrice(price);
        snackEntity.setWeight(weight);
        snackRepository.save(snackEntity);

        return "스낵 테이블 생성";
    }

    public List<SnackResDto> getSnackList() {
        List<SnackEntity> snackList = snackRepository.findByDeletedFalse();
        List<SnackResDto> snackResDtoList = new ArrayList<>();
        for (SnackEntity entity : snackList) {
            snackResDtoList.add(SnackResDto.from(entity));
        }
        return snackResDtoList;
    }

    public SnackResDto getSnackById(Long id) {
        SnackEntity snackEntity = snackRepository.findByIdAndDeletedFalse(id).orElse(null);
        if (snackEntity == null) {
            return null;
        }
        return SnackResDto.from(snackEntity);
    }

    @Transactional
    public String updateSnack(Long id, String name, String info, String manufacturer, Long price, Long weight) {
        SnackEntity snackEntity = snackRepository.findById(id).orElse(null);
        if (snackEntity == null) {
            return "잘못된 ID 입니다.";
        }
        snackEntity.setName(name);
        snackEntity.setInfo(info);
        snackEntity.setManufacturer(manufacturer);
        snackEntity.setPrice(price);
        snackEntity.setWeight(weight);
        return "수정 성공!";
    }
}
