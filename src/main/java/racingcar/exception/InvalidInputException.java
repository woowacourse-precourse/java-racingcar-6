package racingcar.exception;

public class InvalidInputException {
    public static void longNameException(String name) {
        if (name.length() >= 6) {
            throw new IllegalArgumentException("이름은 최대 5글자 입니다.");
        }
    }

    public static void NotIntegerValueException(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException("횟수는 숫자 여야 합니다.");
            }
        }
    }
}
