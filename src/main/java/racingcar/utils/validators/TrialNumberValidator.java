package racingcar.utils.validators;

import racingcar.utils.enums.Constraints;
import racingcar.utils.enums.ErrorMessage;

public class TrialNumberValidator {
    public static void validateTrialNumber(String trialNumber) {
        checkNumberEmpty(trialNumber);
        checkisInteger(trialNumber);
        checkIsPositive(Integer.parseInt(trialNumber));
    }

    // 빈 입력값 검증
    private static void checkNumberEmpty(String trialNumber) {
        if (trialNumber.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME_ERROR.getMessage());
        }
    }

    // 숫자인지 아닌지 검증 + 정수인지 아닌지 검증
    private static void checkisInteger(String trialNumber) {
        try {
            Integer.parseInt(trialNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_MESSAGE.getMessage());
        }
    }

    // 양수인지 아닌지 검증
    private static void checkIsPositive(int trialNumber) {
        if (trialNumber < Constraints.MINIMUM_POSITIVE_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER_MESSAGE.getMessage());
        }
    }
}
