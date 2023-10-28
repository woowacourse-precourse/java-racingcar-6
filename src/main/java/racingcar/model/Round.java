package racingcar.model;

import racingcar.validation.RoundValidator;
import racingcar.validation.Validator;

public class Round {

    private Integer round;

    //TODO: 타입이 달라달라 어떻게 할래?
    public Round(String round) {
        validate(round);
        this.round = Integer.parseInt(round);
    }

    // TODO: 메서드 명이 좀 아쉬움, round를 바꿔볼까?
    public Boolean hasRound() {
        turn();
        return round >= 0;
    }

    private void turn() {
        round--;
    }

    private void validate(String value) {
        Validator validator = new RoundValidator();
        validator.validate(value);
    }
}
