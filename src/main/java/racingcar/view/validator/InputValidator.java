package racingcar.view.validator;

import java.util.regex.Pattern;
import racingcar.exception.car.InvalidCarNamesInputException;
import racingcar.exception.round.InvalidMaxRoundInputException;

public final class InputValidator {

    private static final String CAR_NAMES_REGEX = "^(\\w+,)+\\w+$";
    private static final String MAX_ROUND_REGEX = "^\\d+$";

    public void validateCarNamesInput(final String input) {
        if (!Pattern.matches(CAR_NAMES_REGEX, input)) {
            throw new InvalidCarNamesInputException();
        }
    }

    public void validateMaxRoundInput(final String input) {
        if (!Pattern.matches(MAX_ROUND_REGEX, input)) {
            throw new InvalidMaxRoundInputException();
        }
    }
}

