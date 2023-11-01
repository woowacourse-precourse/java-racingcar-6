package racingcar.model.validator.moveCount;

import static racingcar.util.GameConstants.MAXIMUM_MOVE_COUNT;
import static racingcar.util.GameConstants.ZERO;

/**
 * {@code MoveCountValidator}의 구현부이다.
 * 정해진 규칙에 따라 이동 횟수를 검증한다.
 */
public class MoveCountValidatorImpl implements MoveCountValidator{
    @Override
    public void validateType(Long input) {
        if (input > MAXIMUM_MOVE_COUNT) {
            throw new IllegalArgumentException(MAXIMUM_MOVE_COUNT + " 이하의 값을 입력해주세요.");
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
