package racingcar.domain;

import static racingcar.utils.ErrorMessage.*;
import static racingcar.utils.Message.PROGRESSBAR_CHAR;

public class Car {
    private final String name;
    private int progress;
    private static final int MIN_NAME_LENGTH = 5;

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
        if (name.length() > MIN_NAME_LENGTH) {
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

    @Override
    public String toString() {
        String progressBar = PROGRESSBAR_CHAR.getMessage();
        return name + " : " + progressBar.repeat(progress);
    }
}
