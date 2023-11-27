package racingcar.view.input.validator;

import static racingcar.view.input.constant.InputSymbolConstant.CAR_NAME_DELIMITER;
import static racingcar.view.input.exception.InputExceptionMessage.CONTAINS_EMPTY_INPUT;
import static racingcar.view.input.exception.InputExceptionMessage.INPUT_DOES_NOT_CONTAIN_DELIMITER;

import racingcar.view.input.exception.InputException;

public interface ContainingDelimiterCheckable {
    default void validateContainsDelimiter(String userInput) {
        if (!userInput.contains(CAR_NAME_DELIMITER.getSymbol())) {
            throw InputException.of(INPUT_DOES_NOT_CONTAIN_DELIMITER.getMessage());
        }
    }
    
    default void validateIsNotEndWithDelimiter(String userInput) {
        if (userInput.endsWith(CAR_NAME_DELIMITER.getSymbol())) {
            throw InputException.of(CONTAINS_EMPTY_INPUT.getMessage());
        }
    }
}