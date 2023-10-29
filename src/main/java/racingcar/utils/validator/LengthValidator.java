package racingcar.utils.validator;

public class LengthValidator {
    public static boolean validate(String input, int maxLength) {
        return input.length() <= maxLength;
    }
}
