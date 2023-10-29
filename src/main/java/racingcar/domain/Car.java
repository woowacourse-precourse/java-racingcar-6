package racingcar.domain;

import static racingcar.utils.ErrorMessage.*;

public class Car {
    private final String name;
    private int progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    private void validateCarName(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage());
        }
    }

    public void moveForward() {
        this.progress++;
    }

}
