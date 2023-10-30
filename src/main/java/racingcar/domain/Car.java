package racingcar.domain;

public class Car {

    private static final int ADVANCE_COUNT_INITIAL_VALUE = 0;

    private String carName;
    private int advanceCount;

    public Car(String carName) {
        this.carName = carName;
        this.advanceCount = ADVANCE_COUNT_INITIAL_VALUE;
    }

    public String getCarName() {
        return carName;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public void setAdvanceCount(int advanceCount) {
        this.advanceCount = advanceCount;
    }
}
