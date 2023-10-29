package racingcar.exception;

public class LengthException {
    public static void validateLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("입력한 문자열의 길이가 6 이상입니다.");
        }
    }
}
