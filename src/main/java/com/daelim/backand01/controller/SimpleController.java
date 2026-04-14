package com.daelim.backand01.controller;

import com.daelim.backand01.domain.dto.PlayRockPaperScissorsReqDto;
import com.daelim.backand01.domain.dto.PlayRockPaperScissorsResDto;
import com.daelim.backand01.domain.dto.YearNameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.daelim.backand01.service.SimpleService;


@RestController
@RequiredArgsConstructor
public class SimpleController {
    private final SimpleService simpleService;
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @PostMapping("/get-random")
    public String getRandom() {
        return simpleService.getRandom();
    }

    @PostMapping("/play-rock-paper-scissors")
    public PlayRockPaperScissorsResDto playRockPaperScissors(
            @RequestBody PlayRockPaperScissorsReqDto playRockPaperScissorsReqDto
    ) {
        String result = simpleService.playRockPaperScissors(playRockPaperScissorsReqDto);
        return new PlayRockPaperScissorsResDto(result);
    }



    //http://localhost:8080/hello-with-name/박시은
    //HTTP 통신
    //http method : GET, POST, DELETE, PUT, PATCH...
    @GetMapping("/hello-with-name/{name}")
    public String helloByPathVariable(@PathVariable String name) {
        return "Hello World!!" + name;
    }

    @GetMapping("/hello-by-request-param")
    public String helloByRequestParam(@RequestParam String name) {
        return "Hello World!!" + name;
    }//http://localhost:8080/hello-by-request-param?name=박시은

    @GetMapping("/hello-with-year/{year}/{name}")
    public String helloWithYear(@PathVariable int year, @PathVariable String name) {
        return year + "년" + name + "님, Hello!";
    }

    @GetMapping("/hello-with-year-request-param")
    public String helloWithYearRequestParam(@RequestParam Long year, @RequestParam String name) {
        return year + "년" + name + "님, Hello!";
    }

    @GetMapping("hello-by-dto")
    public String helloByDto(YearNameDto yearNameDto) {
        return yearNameDto.year() + "년" + yearNameDto.name() +"님, hello 여기는 dto야";
    }
}
