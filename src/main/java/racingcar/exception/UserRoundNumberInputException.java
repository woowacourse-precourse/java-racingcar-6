package racingcar.exception;

public class UserRoundNumberInputException {
    private static final String IS_NOT_NUMBER_MESSAGE = "숫자만 입력해주세요";
    private static final String IS_BLANK_MESSAGE = "공백을 입력하시면 안됩니다.";
    private static final String IS_NOT_ZERO_OR_MINUS = "0이나 음수값을 입력하시면 안됩니다.";
    private static final int Zero = 0;

    public UserRoundNumberInputException(String input) {
        isBlank(input);
        isNumber(input);
        isZeroMinus(input);
    }

    private void isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER_MESSAGE);
        }
    }

    private void isBlank(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            throw new IllegalArgumentException(IS_BLANK_MESSAGE);
        }
    }

    private void isZeroMinus(String userInput) {
        if (Integer.parseInt(userInput) <= Zero) {
            throw new IllegalArgumentException(IS_NOT_ZERO_OR_MINUS);
        }
    }
}
