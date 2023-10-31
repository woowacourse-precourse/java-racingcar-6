package racingcar.validator;

import racingcar.domain.RaceCountRule;

public class InputMoveCountValidator {

    private InputMoveCountValidator() {
    }

    public static void validateCount(final String moveCount) {
        validateNumber(moveCount);
        validateRange(Integer.parseInt(moveCount));
    }

    private static void validateNumber(final String moveCount) {
        try {
            Integer.parseInt(moveCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력해야 합니다.");
        }
    }

    private static void validateRange(final int moveCount) {
        if (RaceCountRule.isNotInRange(moveCount)) {
            throw new IllegalArgumentException("시도 횟수는 1 이상 10 이하의 숫자를 입력해야 합니다.");
        }
    }
}
