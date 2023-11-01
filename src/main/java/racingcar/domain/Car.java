package racingcar.domain;

public class Car {

    private final String carName;
    private int goCount;

    public Car(String carName, int goCount) {
        this.carName = carName;
        this.goCount = goCount;
    }

    public String getCarName() {
        return carName;
    }

    public int getGoCount() {
        return goCount;
    }

    public void goAhead() {
        this.goCount++;
    }
}
