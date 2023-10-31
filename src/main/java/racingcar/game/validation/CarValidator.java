package racingcar.game.validation;

import static racingcar.game.constant.CarExceptionMessage.*;

public class CarValidator implements Validator<String>{

    @Override
    public void execute(String name) {
        validateHavingValue(name);
        validateNameLength(name);
        validateSideBlank(name);
    }

    private void validateHavingValue(String name) {
        if (name == null) {
            throw new IllegalArgumentException(SHOULD_HAVE_VALUE);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(OUT_OF_LENGTH_RANGE);
        }
    }

    private void validateSideBlank(String name) {
        if (name.startsWith(" ") || name.endsWith(" ")){
            throw new IllegalArgumentException(NOT_ALLOW_SIDE_BLANK);
        }
    }
}
