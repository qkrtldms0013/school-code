package com.daelim.backand01.controller;


import com.daelim.backand01.domain.dto.snack.CreateSnackReqDto;
import com.daelim.backand01.domain.dto.snack.SnackResDto;
import com.daelim.backand01.service.SnackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SnackController {
    private final SnackService snackService;

    @PostMapping("/create-snack")
    public String createSnack(@RequestBody CreateSnackReqDto dto) {
        return snackService.createSnack(
                dto.getName(),
                dto.getInfo(),
                dto.getManufacturer(),
                dto.getPrice(),
                dto.getWeight()
        );
    }
    @GetMapping("/get-snack-list")
    public List<SnackResDto> getSnackList() {
        return snackService.getSnackList();
    }


    @PostMapping("/update-snack/{id}")
    public String updateSnack(@PathVariable Long id, @RequestBody CreateSnackReqDto dto) {
        return snackService.updateSnack(
                id,
                dto.getName(),
                dto.getInfo(),
                dto.getManufacturer(),
                dto.getPrice(),
                dto.getWeight()
        );
    }
}
