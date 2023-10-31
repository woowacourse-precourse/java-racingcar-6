package racingcar.validator;

public class InputValidateService {
    private final InputCarNameValidator inputCarNameValidator = new InputCarNameValidator();
    private final InputTryCountValidator inputTryCountValidator = new InputTryCountValidator();

    public void validateInputCarName(String carName) {
        inputCarNameValidator.validateNonInputCarName(carName);
        inputCarNameValidator.validateNonCommaCarName(carName);
        inputCarNameValidator.validateOverFiveCarName(carName);
        inputCarNameValidator.validateWrongType(carName);
    }

    public void validateInputTryCount(String tryCount) {
        inputTryCountValidator.validateNonInputTryCount(tryCount);
        inputTryCountValidator.validateNonIntegerTryCount(tryCount);
        inputTryCountValidator.validateNonOverOneTryCount(tryCount);
        inputTryCountValidator.validateMinusTryCount(tryCount);
    }
}
