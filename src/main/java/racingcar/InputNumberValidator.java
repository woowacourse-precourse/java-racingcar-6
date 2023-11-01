package racingcar;

public class InputNumberValidator {
    public static void validateInputNumber(Integer inputNumber) {
        if (isNegative(inputNumber)) {
            throw new IllegalArgumentException("0보다 큰 숫자만 입력할 수 있습니다.");
        }
    }

    private static boolean isNegative(Integer inputNumber) {
        return inputNumber <= 0;
    }
}
