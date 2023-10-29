package racingcar.utils.validator;

public class IntegerRangeValidator {
    public static boolean validate(String input, int min, int max) {
        int value = Integer.parseInt(input);
        return value > min && value <= max;
    }
}
