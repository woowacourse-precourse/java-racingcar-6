package racingcar.validation;

import racingcar.message.ErrorMessage;
import racingcar.resource.RegularExpression;

public class InputValidator {

    public static void validateRoundInput(String roundInputNumber) {
        StringValidator.stringNullAndBlankCheck(roundInputNumber);
        validateNumber(roundInputNumber);
        validateNumberZero(roundInputNumber);
    }

    public static void validateNumber(String inputNumber) {
        if (!inputNumber.matches(RegularExpression.NUMBER_REGEX.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_TRY_TYPE_MESSAGE.getValue());
        }
    }

    public static void validateNumberZero(String inputNumber) {
        if (Integer.parseInt(inputNumber) == 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_TRY_ZERO_MESSAGE.getValue());
        }
    }
}