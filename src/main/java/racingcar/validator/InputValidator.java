package racingcar.validator;

public class InputValidator {

    private static final String INPUT_NUMBER_CORRECT_TYPE = "[0-9]+";

    public void validateInputNumber(String inputNumber) {
        if (isInputNumberNotDigit(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInputNumberNotDigit(String inputNumber) {
        return (!inputNumber.matches(INPUT_NUMBER_CORRECT_TYPE));
    }
}
