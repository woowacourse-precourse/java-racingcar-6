package racingcar.Validator;

public class Validator {

    public static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백이 존재합니다.");
        }
    }

    public static void validateNotEndsWithComma(String input) {
        int namesLength = input.length();
        if (isEndWithComma(input, namesLength)) {
            throw new IllegalArgumentException(",로 끝나면 안됩니다.");
        }
    }

    private static boolean isEndWithComma(String input, int inputLength) {
        return input.charAt(inputLength - 1) == ',';
    }
}
