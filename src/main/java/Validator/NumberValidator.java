package Validator;

public class NumberValidator {
    private static NumberValidator numberValidator = null;
    private static final int MIN = 0;
    private static final int MAX = 9;

    public static NumberValidator getInstance() {
        if (NumberValidator.numberValidator == null) {
            return NumberValidator.numberValidator = new NumberValidator();
        }
        return NumberValidator.numberValidator;
    }

    public void validateRandomNumber(int number) {
        if (number < NumberValidator.MIN) {
            throw new IllegalArgumentException("숫자는 " + NumberValidator.MIN + " 이상이어야 합니다.");
        }
        if (number > NumberValidator.MAX) {
            throw new IllegalArgumentException("숫자는 " + NumberValidator.MAX + " 이하여야 합니다.");
        }
    }

    public int getMax() {
        return NumberValidator.MAX;
    }

    public int getMin() {
        return NumberValidator.MIN;
    }
}
