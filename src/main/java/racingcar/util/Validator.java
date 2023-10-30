package racingcar.util;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern nameValidatePattern = Pattern.compile("([\\S]{1,})");
    private static final Pattern numberValidatePattern = Pattern.compile("([\\d]{1,})");

    public static void validateInputSpace(String input) {
        if (!validateInputPattern(input, nameValidatePattern)) {
            throw new IllegalArgumentException(Message.EXCEPTION_INPUT_NAMES_SPACE.message);
        }
    }

    public static void validateInputLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(Message.EXCEPTION_INPUT_NAMES_LENGTH.message);
        }
    }

    public static void validateInputNumberZero(String input) {
        if (input.equals("0")) {
            throw new IllegalArgumentException(Message.EXCEPTION_INPUT_NUMBER_RANGE.message);
        }
    }

    public static void validateInputNumber(String input) {
        if (!validateInputPattern(input, numberValidatePattern)) {
            throw new IllegalArgumentException(Message.EXCEPTION_INPUT_NUMBER_RANGE.message);
        }
    }

    private static boolean validateInputPattern(String input, Pattern pattern) {
        return pattern.matcher(input).matches();
    }

    private enum Message {
        EXCEPTION_INPUT_NAMES_SPACE("공백을 제거해주세요."),
        EXCEPTION_INPUT_NAMES_LENGTH("이름은 1~5글자로 작성해주세요."),
        EXCEPTION_INPUT_NUMBER_RANGE("1이상의 정수만 입력해주세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
