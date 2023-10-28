package racingcar.model;

import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

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
        ValidatorFactory validatorFactory = ValidatorFactory.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator(this.getClass());
        validator.validate(value);
    }
}
