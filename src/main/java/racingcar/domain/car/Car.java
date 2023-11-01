package racingcar.domain.car;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Car {

    private static final int START_RANGE_NUMBER = 0;
    private static final int LIMIT_RANGE_NUMBER = 9;
    private static final int LIMIT_ACCELERATOR = 4;
    private final String name;
    private int mileage = START_RANGE_NUMBER;

    public Car(String name) {
        this.name = name;
    }

    public void recordDistance() {
        if (isMoveCar()) {
            mileage++;
        }
    }

    private boolean isMoveCar() {
        return LIMIT_ACCELERATOR <= pickNumberInRange(START_RANGE_NUMBER, LIMIT_RANGE_NUMBER);
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }
}