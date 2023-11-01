package racingcar.domain;

import static racingcar.global.constants.NumberType.MAX_LENGTH_OF_NUMBER;
import static racingcar.global.exception.ErrorMessage.INVALID_NAME_CHARACTERS;
import static racingcar.global.exception.ErrorMessage.INVALID_NAME_LENGTH;

import racingcar.global.exception.RaceException;

public class Name {
    private String value;

    private Name(final String value) {
        Validator.validateName(value);
        this.value = value;
    }

    public static Name of(final String value) {
        return new Name(value);
    }

    public String getValue() {
        return value;
    }

    private static class Validator {
        private static void validateName(final String name) {
            validateLength(name);
            validateCharacters(name);
        }

        private static void validateLength(final String name) {
            if (isLengthExceeded(name)) {
                throw RaceException.of(INVALID_NAME_LENGTH);
            }
        }

        private static boolean isLengthExceeded(final String name) {
            return name.length() > MAX_LENGTH_OF_NUMBER.getValue();
        }

        private static void validateCharacters(final String name) {
            if (containsInvalidCharacters(name)) {
                throw RaceException.of(INVALID_NAME_CHARACTERS);
            }
        }

        private static boolean containsInvalidCharacters(final String name) {
            return !name.matches("[a-zA-Z]+");
        }
    }
}
