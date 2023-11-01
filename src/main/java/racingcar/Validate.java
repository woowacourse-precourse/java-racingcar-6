package racingcar;

public class Validate {
    public static void validateInput(String input) throws IllegalArgumentException {
        checkEmpty(input);
        isInvalidLength(input);
    }

    public static void isInvalidLength(String input) throws IllegalArgumentException {
        checkEmpty(input);
        if (input.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public static void checkEmpty(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다");
        }
    }
}