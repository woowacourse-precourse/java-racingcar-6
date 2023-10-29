package racingcar.service;

import racingcar.validator.InputValidator;

public class ValidateService {

    private final InputValidator inputValidator = new InputValidator();

    public void validateInputCarName(String carName) {
        inputValidator.validateInputCarName(carName);
    }

    public void validateInputNumber(String inputNumber) {
        inputValidator.validateInputNumber(inputNumber);
    }
}
