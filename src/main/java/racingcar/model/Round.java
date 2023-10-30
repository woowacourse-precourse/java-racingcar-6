package racingcar.model;

import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

public class Round {

    private Integer round;

    private Round(String round) {
        validate(round);
        this.round = Integer.valueOf(round);
    }

    public static Round of(String round) {
        return new Round(round);
    }

    public Boolean hasRound() {
        return round > 0;
    }

    public void turn() {
        round--;
    }

    private void validate(String value) {
        ValidatorFactory validatorFactory = ValidatorFactory.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator(this.getClass());
        validator.validate(value);
    }
}
