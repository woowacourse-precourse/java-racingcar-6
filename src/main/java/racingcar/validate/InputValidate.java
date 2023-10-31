package racingcar.validate;

import java.util.Arrays;
import racingcar.domain.constant.Delimiter;
import racingcar.enums.ExceptionMessage;

public class InputValidate {
    public void validateNames(String input) {
        String[] carNames = input.split(Delimiter.INPUT_NAME_DELIMITER.getValue());
        validateNull(carNames);
        validateLength(carNames);
    }

    private void validateNull(String[] carNames) {
        if (Arrays.stream(carNames).map(String::trim).anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NULL_EXCEPTION_MESSAGE.getValue());
        }
    }

    private void validateLength(String[] carNames) {
        if (Arrays.stream(carNames).anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_LENGTH_EXCEPTION_MESSAGE.getValue());
        }
    }

}
