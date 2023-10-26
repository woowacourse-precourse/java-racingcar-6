package racingcar.entity.car;

import static racingcar.constants.ErrorConstants.*;

public class Name {
    private String name;

    public Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}