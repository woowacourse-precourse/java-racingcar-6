package racingcar.input;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static String validate(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열입니다.");
        }
        return input.trim();
    }
}
