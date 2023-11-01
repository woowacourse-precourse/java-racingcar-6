package racingcar.dto.request;

import racingcar.exception.InvalidCarNameException;

public record CarName(String name) {

    private static final Integer MAX_NAME_LENGTH = 5;

    public CarName {
        validateNameLength(name.length());
    }

    private void validateNameLength(Integer nameLength) {
        if (nameLength > MAX_NAME_LENGTH) {
            throw new InvalidCarNameException();
        }
    }
}
