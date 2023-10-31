package racingcar.game.validation;

import static racingcar.game.constant.RoundExceptionMessage.NOT_INTEGER;
import static racingcar.game.constant.RoundExceptionMessage.OUT_OF_RANGE;

public class RoundValidator implements Validator {

    @Override
    public void execute(String stringMovingCount) {
        int movingCount = validateInteger(stringMovingCount);
        validateRange(movingCount);
    }

    private int validateInteger(String stringMovingCount) {
        try {
            return Integer.parseInt(stringMovingCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER, e);
        }
    }

    private void validateRange(int movingCount) {
        if (movingCount < 1 || movingCount > 100) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }
}
