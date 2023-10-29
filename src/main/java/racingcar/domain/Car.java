package racingcar.domain;

import java.util.HashMap;

public class Car {
    private final String carName;
    private int advanceNumber;

    public Car(String carName) {
        this.carName = carName;
        this.advanceNumber = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getAdvanceNumber() {
        return advanceNumber;
    }

    public void setAdvanceNumber(int advanceNumber) {
        this.advanceNumber = advanceNumber;
    }
}
