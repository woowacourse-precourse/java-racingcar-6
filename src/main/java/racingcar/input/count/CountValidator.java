package racingcar.input.count;

public class CountValidator {
    public static boolean isValid(String input) {
        return input.matches("[0-9]+");
    }
}
