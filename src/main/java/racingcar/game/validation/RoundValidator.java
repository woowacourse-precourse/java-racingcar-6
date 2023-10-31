package racingcar.game.validation;

import static racingcar.game.constant.RoundExceptionMessage.NOT_INTEGER;

public class RoundValidator implements Validator {

    @Override
    public void execute(String name) {
        validateInteger(name);
    }

    private void validateInteger(String name) {
        try {
            Integer.parseInt(name);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER, e);
        }
    }
}
