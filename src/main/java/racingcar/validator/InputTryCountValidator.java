package racingcar.validator;

import racingcar.domain.RaceCountRule;

public class InputTryCountValidator {

    private InputTryCountValidator() {
    }

    public static void validateCount(final String inputRaceCount) {
        validateNumber(inputRaceCount);
        validateRange(Integer.parseInt(inputRaceCount));
    }

    private static void validateNumber(final String inputRaceCount) {
        try {
            Integer.parseInt(inputRaceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력해야 합니다.");
        }
    }

    private static void validateRange(final int inputRaceCount) {
        if (RaceCountRule.isNotInRange(inputRaceCount)) {
            throw new IllegalArgumentException("시도 횟수는 1 이상 10 이하의 숫자를 입력해야 합니다.");
        }
    }
}
