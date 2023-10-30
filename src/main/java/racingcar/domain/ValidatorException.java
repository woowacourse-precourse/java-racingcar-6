package racingcar.domain;

import java.util.Collections;
import racingcar.model.Car;
import racingcar.model.InputData;
import racingcar.preprocess.Validator;

public class ValidatorException {
    public static void validateCarNames(Car car) {
        if (!isCarNameValid(car)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isCarNameValid(Car car) {
        boolean lengthValid = Validator.isCarNameOverFiveCharacters(car.getCarName());
        boolean charactersValid = Validator.validateDelimiter(car.getCarName());
        boolean nonEmpty = Validator.isEmpty(car.getCarName());

        return lengthValid && charactersValid && nonEmpty;
    }

    public static void validateInputAttemptsCount(InputData inputData) {
        if (!isInputAttemptsCountValid(inputData)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInputAttemptsCountValid(InputData inputData) {
        boolean numericInputValid = Validator.isNonNumericInput(inputData.getAttemptCount());
        boolean nonEmpty = Validator.isEmpty(Collections.singletonList(inputData.getAttemptCount()));

        return numericInputValid && nonEmpty;
    }
}
