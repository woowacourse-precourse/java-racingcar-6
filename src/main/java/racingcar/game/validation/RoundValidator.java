package racingcar.game.validation;

import static racingcar.game.constant.RoundExceptionMessage.NOT_INTEGER;

public class RoundValidator implements Validator {

    @Override
    public void execute(String name) {
        int movingCount = validateInteger(name);
    }

    private int validateInteger(String name) {
        try {
            return Integer.parseInt(name);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER, e);
        }
    }
}
