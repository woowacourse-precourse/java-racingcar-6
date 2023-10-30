package racingcar;

public class Validation {
    private static int checkSize(String str) {
        return str.length();
    }

    public static void validateLengthOfName(String input) {
        if (checkSize(input) == Constants.MIN_NAME_LENGTH || checkSize(input) > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름을 1자 이상, 5자 이하로 설정해주세요.");
        }
    }

    public static void isNotNumber(String s) {
        if (!Character.isDigit(s.charAt(0))) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
