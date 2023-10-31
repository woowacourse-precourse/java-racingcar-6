package racingcar.domain;

import static racingcar.utils.ErrorMessage.*;

import static racingcar.utils.Message.ProgressBar;

public class Car {
    private final String name;
    private int progress;

    private Car(String name, int progress) {
        validateCarName(name);
        this.name = name;
        this.progress = progress;
    }

    public static Car createCar(String name, int progress) {
        return new Car(name, progress);
    }

    public static Car createZeroProgressCar(String name) {
        return new Car(name, 0);
    }

    public void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage());
        }
    }

    public void moveForward() {
        this.progress++;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

}
