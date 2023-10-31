package racingcar.domain;

import racingcar.utils.Constants;

public class Name {
    private final String name;

    public Name(String name) {
        validateNameNotEmptyOrBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validateNameNotEmptyOrBlank(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException(Constants.ERROR_UNKNOWN_NAME);
        }
    }

    public void validateNameLength(String name) {
        if (name.length() > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Constants.ERROR_NAME_MAX_LENGTH);
        }
    }


}
