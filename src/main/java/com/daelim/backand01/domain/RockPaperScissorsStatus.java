package com.daelim.backand01.domain;

import lombok.Getter;

@Getter
public enum RockPaperScissorsStatus {
    ROCK("바위"), PAPER("보"), SCISSORS("가위");

    private final String korean;

    RockPaperScissorsStatus(String korean) {
        this.korean = korean;
    }

}
