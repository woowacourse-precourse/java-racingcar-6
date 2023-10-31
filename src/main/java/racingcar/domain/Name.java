package racingcar.domain;

import static racingcar.utils.ErrorMessages.CAR_NAME_BLANK;
import static racingcar.utils.ErrorMessages.CAR_NAME_CONTAIN_BLANK;
import static racingcar.utils.ErrorMessages.CAR_NAME_EMPTY;
import static racingcar.utils.ErrorMessages.OUT_OF_LENGTH_CAR_NAME;

import racingcar.utils.ErrorMessages;


public class Name {
    public static final int MIN_NAME_SIZE = 5;

    private final String name;

    public Name(String name) {
        validateSize(name);
        validateIsEmpty(name);
        this.name = name;
    }

    private void validateSize(String name) {
        if (name.length() > MIN_NAME_SIZE) {
            throw new IllegalArgumentException(OUT_OF_LENGTH_CAR_NAME);
        }
    }

    private void validateIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
