package racingcar.service;

import racingcar.validator.InputValidator;

public class ValidateService {

    private final InputValidator inputValidator = new InputValidator();

    public void validateInputNumber(String inputNumber) {
        inputValidator.validateInputNumber(inputNumber);
    }
}
