package com.daelim.backand01.service;

import com.daelim.backand01.domain.RockPaperScissorsStatus;
import java.util.Random;
import com.daelim.backand01.domain.dto.PlayRockPaperScissorsReqDto;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    public String hello() {
        return "Hello";
    }
    public String hellloByPathVariable(String name) {
        return "Hello" + name;
    }

    public String getRandom() {
        Random random = new Random();
        int number = random.nextInt(3);

        if (number == 0) {
            return "가위";
        } else if (number == 1) {
            return "바위";
        } else {
            return "보";
        }
    }


    public String playRockPaperScissors(
            PlayRockPaperScissorsReqDto playRockPaperScissorsDto
    ) {
        RockPaperScissorsStatus clientStatus = playRockPaperScissorsDto.status();

        Random random = new Random();
        int number = random.nextInt(3);

        RockPaperScissorsStatus serverStatus = RockPaperScissorsStatus.ROCK;

        if (number == 0) {
            serverStatus = RockPaperScissorsStatus.ROCK;
        } else if (number == 1) {
            serverStatus = RockPaperScissorsStatus.PAPER;
        } else {
            serverStatus = RockPaperScissorsStatus.SCISSORS;
        }

        if (clientStatus == RockPaperScissorsStatus.SCISSORS) {
            if (serverStatus == RockPaperScissorsStatus.ROCK) {
                return "패배";
            }
            if (serverStatus == RockPaperScissorsStatus.ROCK) {
            return "승리";
            }
            if (serverStatus == RockPaperScissorsStatus.PAPER) {
                return "패배";
            }
        }

        if (clientStatus == RockPaperScissorsStatus.PAPER) {
            if (serverStatus == RockPaperScissorsStatus.SCISSORS) {
                return "패배";
            }
            if (serverStatus == RockPaperScissorsStatus.ROCK) {
                return "승리";
            }
        }

        return "무승부";
    }
}
