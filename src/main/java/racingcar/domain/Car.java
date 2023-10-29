package racingcar.domain;

import static racingcar.utils.ErrorMessage.*;

public record Car(String name, int progress) {
    public Car(String name) {
        this(name,0);
        validateCarName(name);
    }

    private void validateCarName(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage());
        }
    }
}
