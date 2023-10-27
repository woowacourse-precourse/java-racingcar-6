package racingcar.validator;

public class UserInputValidator {

    private UserInputValidator() {
    }

    public static void validCarNameLength(String userInput) {
        if (userInput.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
