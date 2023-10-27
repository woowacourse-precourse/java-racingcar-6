package racingcar.domain;

import racingcar.global.exception.RacingCarException;

import java.util.Objects;

import static racingcar.global.exception.ErrorMessage.CONTAIN_IMPROPER_LETTER;
import static racingcar.global.exception.ErrorMessage.NULL;

public class CarNameValidator {
    private CarNameValidator() {
    }

    public static void validateCarName(final String input) {
        validateNull(input);
        validateWhiteSpace(input);
    }

    private static void validateNull(final String input) {
        if (Objects.isNull(input)) {
            throw RacingCarException.of(NULL);
        }
    }

    private static void validateWhiteSpace(final String input) {
        if (hasWhiteSpace(input)) {
            throw RacingCarException.of(CONTAIN_IMPROPER_LETTER);
        }
    }

    private static boolean hasWhiteSpace(final String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }
}
