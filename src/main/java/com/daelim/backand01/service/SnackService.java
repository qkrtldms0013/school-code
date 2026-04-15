package com.daelim.backand01.service;


import com.daelim.backand01.domain.dto.snack.CreateSnackReqDto;
import com.daelim.backand01.domain.dto.snack.SnackResDto;
import com.daelim.backand01.domain.dto.snack.UpdateSnackReqDto;
import com.daelim.backand01.domain.entity.Snack;
import com.daelim.backand01.repository.SnackRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SnackService {
    private final SnackRepository snackRepository;

    public String createSnack(CreateSnackReqDto reqDto) {
        Snack snack = new Snack(
                reqDto.name(),
                reqDto.info(),
                reqDto.manufacturer(),
                reqDto.price(),
                reqDto.weight()
        );
        snackRepository.save(snack);

        return "스낵 테이블 생성";
    }

    public List<SnackResDto> getSnackList() {
        List<Snack> snackList = snackRepository.findByDeletedFalse();
        List<SnackResDto> snackResDtoList = new ArrayList<>();
        for (Snack entity : snackList) {
            snackResDtoList.add(SnackResDto.from(entity));
        }
        return snackResDtoList;
    }

    public SnackResDto getSnackById(Long id) {
        Snack snack = snackRepository.findByIdAndDeletedFalse(id).orElse(null);
        if (snack == null) {
            return null;
        }
        return SnackResDto.from(snack);
    }

    @Transactional
    public String updateSnack(Long id, UpdateSnackReqDto reqDto) {
        Snack snack = snackRepository.findById(id).orElse(null);
        if (snack == null) {
            return "잘못된 ID 입니다.";
        }
        snack.update(reqDto.price(), reqDto.weight());
        return "수정 성공!";
    }
}
