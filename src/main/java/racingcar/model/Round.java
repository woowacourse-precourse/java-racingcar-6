package racingcar.model;

import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

public class Round {

    private Long round;

    //TODO: 타입이 달라달라 어떻게 할래?
    public Round(String round) {
        validate(round);
        this.round = Long.valueOf(round);
    }

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
