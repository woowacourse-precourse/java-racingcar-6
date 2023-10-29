package racingcar.domain;

public class Car {

    private String carName;
    private int advanceCount;

    public Car(String carName) {
        this.carName = carName;
        this.advanceCount = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public void setAdvanceCount(int advanceNumber) {
        this.advanceCount = advanceNumber;
    }
}
