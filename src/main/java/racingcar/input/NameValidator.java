package racingcar.input;

import java.util.Optional;

public class NameValidator {
    public static boolean hasValidCharacters(String input) {
        return Optional.ofNullable(input).map(s -> s.matches("[A-Za-z,]+")).orElse(false);
    }
}
