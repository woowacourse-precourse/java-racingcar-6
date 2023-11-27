package racingcar.view.input.validator;

import racingcar.view.input.exception.InputException;
import racingcar.view.input.exception.InputExceptionMessage;

public interface NotEmptyCheckable {
    default void validateIsNotEmpty(String userInput) {
        if (userInput.isBlank()) {
            throw InputException.of(InputExceptionMessage.IS_EMPTY.getMessage());
        }
    }
}