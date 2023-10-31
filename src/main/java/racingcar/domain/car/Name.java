package racingcar.domain.car;

import static racingcar.domain.car.NameConstants.ALPHABET_PATTERN;
import static racingcar.domain.car.NameConstants.LENGTH_IS_OVER_MAX;
import static racingcar.domain.car.NameConstants.MAX_LENGTH;
import static racingcar.domain.car.NameConstants.NOT_ALPHABETIC;

import java.util.Objects;

public record Name(String value) {
    public Name {
        validate(value);
    }

    private void validate(String input) {
        validateLength(input);
        validateContent(input);
    }

    private void validateLength(String input) {
        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_IS_OVER_MAX);
        }
    }

    private void validateContent(String input) {
        if (!isAlphabetic(input)) {
            throw new IllegalArgumentException(NOT_ALPHABETIC);
        }
    }

    private boolean isAlphabetic(String input) {
        return input.matches(ALPHABET_PATTERN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }
}
