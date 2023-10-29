package racingcar.utils.validator;

public class AsciiValidator {

    public static boolean validate(String input) {
        return input.chars().allMatch(c -> c >= 32 && c <= 127);
    }
}