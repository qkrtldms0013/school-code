package com.daelim.backand01.controller;


import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;



@RestController
public class LottoController {
    @GetMapping("/lotto")
    public String getLottoNumbers(
            @RequestParam long min,
            @RequestParam long max,
            @RequestParam long number
    ) {
        List<Long> numbers = new ArrayList<>();
        Random random = new Random();

        while (numbers.size() < number) {
            long num = min + (long) (Math.random() * (max - min + 1));

            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return min + " ~ " + max + " 사이에서 " + number + "개 뽑은 숫자: " + numbers;
    }

}

//http://localhost:8080/lotto?min=1&max=45&number=6
