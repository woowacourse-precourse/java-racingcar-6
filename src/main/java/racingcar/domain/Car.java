package racingcar.domain;

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

    public void forwardOneBlock() {
        this.advanceNumber++;
    }
}

