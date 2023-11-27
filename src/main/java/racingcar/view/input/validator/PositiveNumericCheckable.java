package racingcar.view.input.validator;

import static racingcar.view.input.constant.InputValueConstant.NUMERIC_INPUT_UNDER_LIMIT;

import racingcar.view.input.exception.InputException;
import racingcar.view.input.exception.InputExceptionMessage;

public interface PositiveNumericCheckable {

    default void validateIsNumeric(String userInput) {
        try {
            parseToInt(userInput);
        } catch (NumberFormatException e) {
            throw InputException.of(InputExceptionMessage.NOT_NUMERIC_TYPE.getMessage());
        }
    }

    default void validateIsPositive(String userInput) {
        if (parseToInt(userInput) <= NUMERIC_INPUT_UNDER_LIMIT.getValue()) {
            throw InputException.of(InputExceptionMessage.NUMERIC_INPUT_UNDER_LOWER_LIMIT.getMessage());
        }
    }

    private int parseToInt(String userInput) {
        return Integer.parseInt(userInput);
    }
}