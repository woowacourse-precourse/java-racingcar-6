package racingcar.Exception;

public class UserInputException {
    private void validateIsNumber(String userInput) {
        if (!userInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException();
        }
    }

    public void validateUserInput(String userInput) {
        validateIsNumber(userInput);
    }
}
