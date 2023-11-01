package racingcar.global;

import java.util.regex.Pattern;

public class InputVerifier {
    private static final Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile("^[1-9]\\d*$");

    private InputVerifier() {
    }

    public static boolean isPositiveInteger(String input) {
        return POSITIVE_INTEGER_PATTERN.matcher(input).matches();
    }
}
