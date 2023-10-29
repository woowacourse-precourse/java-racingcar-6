package racingcar.utils.validator;

public class IsIntegerValidator {

    public static boolean validate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
