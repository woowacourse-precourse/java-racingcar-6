package racingcar.game.validation;

import static racingcar.game.constant.RoundExceptionMessage.OUT_OF_RANGE;

public class RoundValidator implements Validator<Integer> {

    @Override
    public void execute(Integer movingCount) {
        validateRange(movingCount);
    }

    private void validateRange(int movingCount) {
        if (movingCount < 1 || movingCount > 100) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }
}
