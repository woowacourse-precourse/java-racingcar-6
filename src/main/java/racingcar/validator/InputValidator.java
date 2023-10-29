package racingcar.validator;

public class InputValidator {

    private static final String INPUT_NUMBER_CORRECT_TYPE = "[0-9]+";
    private static final int INPUT_NAME_MAXIMUM_LENGTH = 5;

    public void validateInputCarName(String inputCarName) {
        if (isInputCarNameOverLength(inputCarName)) {
            throw new IllegalArgumentException();
        }

    }

    public void validateInputNumber(String inputNumber) {
        if (isInputNumberNotDigit(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInputCarNameOverLength(String inputCarName) {
        return (inputCarName.length() > INPUT_NAME_MAXIMUM_LENGTH);
    }

    private boolean isInputNumberNotDigit(String inputNumber) {
        return (!inputNumber.matches(INPUT_NUMBER_CORRECT_TYPE));
    }
}
