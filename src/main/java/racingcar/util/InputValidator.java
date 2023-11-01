package racingcar.util;

public class InputValidator {
    public void isValidInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INPUT_ERROR_MESSAGE);
        }
    }

    public void isValidNameLength(String userInput) {
        if (userInput.length() > Constant.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Message.INPUT_ERROR_MESSAGE);
        }
    }

}
