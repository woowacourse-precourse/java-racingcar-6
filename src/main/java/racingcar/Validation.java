package racingcar;

public class Validation {
    private static int checkSize(String str) {
        return str.length();
    }

    public static void validateLengthOfName(String input) {
        if (input.isEmpty() || checkSize(input) > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }


    public static void isNotNumber(String s) {
        if (!Character.isDigit(s.charAt(0))) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

}
