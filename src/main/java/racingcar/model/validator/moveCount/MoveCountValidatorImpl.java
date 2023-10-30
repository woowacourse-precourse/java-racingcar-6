package racingcar.model.validator.moveCount;

import static racingcar.util.GameConstants.MAXIMUM_MOVE_COUNT;
import static racingcar.util.GameConstants.ZERO;

public class MoveCountValidatorImpl implements MoveCountValidator{
    @Override
    public void validateType(Long input) {
        if (input > MAXIMUM_MOVE_COUNT) {
            throw new IllegalArgumentException("자료형에 맞는 값을 입력해주세요.");
        }
    }

    @Override
    public void validatePositive(Long input) {
        if (input < ZERO) {
            throw new IllegalArgumentException(ZERO + "이상의 값을 입력해주세요.");
        }
    }

    @Override
    public void validateAll(Long input) {
        validateType(input);
        validatePositive(input);
    }
}
