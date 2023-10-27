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

    //TODO: 진행중인지 확인하는 것 뿐만 아니라 감소까지 함. 고쳐보자
    public Boolean isContinue() {
        if (round > 0) {
            round--;
            return true;
        }
        return false;
    }

    private void validate(String value) {
        Validator validator = new RoundValidator();
        validator.validate(value);
    }
}
