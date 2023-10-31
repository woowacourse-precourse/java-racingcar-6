package racingcar.domain;

import racingcar.dto.CarStatus;
import racingcar.exception.OverCarMaxNameLengthException;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int driveCount;

    public Car(String name) {
        name = name.trim();
        verifyNameLength(name);
        this.name = name;
        this.driveCount = 0;
    }

    public void drive() {
        driveCount++;
    }

    public CarStatus getStatus() {
        return new CarStatus(name, driveCount);
    }

    private static void verifyNameLength(String name) {
        if (MAX_NAME_LENGTH < name.length()) {
            throw new OverCarMaxNameLengthException(MAX_NAME_LENGTH);
        }
    }
}
