package racingcar.model;

import racingcar.util.Constants;

public class Name {
    private final String name;

    public Name(String name) {
        validateNameSize(name);
        this.name = name;
    }

    public void validateNameSize(String name) {
        int maxSize = Integer.parseInt(Constants.NAME_MAX_SIZE.constant);
        if (name.length() > maxSize) {
            throw new IllegalArgumentException(Constants.EXCEED_NAME_SIZE.constant);
        }
    }

    public String getName() {
        return this.name;
    }
}
