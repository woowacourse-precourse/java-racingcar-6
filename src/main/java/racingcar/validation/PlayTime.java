package racingcar.validation;

import racingcar.validation.playtime.EmptyPlayTimeValidator;
import racingcar.validation.playtime.IntegerTypeValidator;
import racingcar.validation.playtime.MinimumPlayTimeValidator;
import racingcar.validation.playtime.PlayTimeValidator;

public class PlayTime {
    private static final PlayTimeValidator[] playTimeValidator = {
            new EmptyPlayTimeValidator(),
            new IntegerTypeValidator(),
            new MinimumPlayTimeValidator()
    };

    public static void isValid(String inputValue) {
        for (PlayTimeValidator validator : playTimeValidator) {
            validator.validate(inputValue);
        }
    }
}
