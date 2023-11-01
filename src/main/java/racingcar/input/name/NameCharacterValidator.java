package racingcar.input.name;

import java.util.Optional;

public class NameCharacterValidator {
    public static boolean hasValidCharacters(String name) {
        return Optional.ofNullable(name).map(s -> s.matches("[A-Za-z,]+")).orElse(false);
    }
}
