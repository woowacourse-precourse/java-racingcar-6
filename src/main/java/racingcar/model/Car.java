package racingcar.model;

public class Car {

    private final String carName;
    private int forwardCount;

    public Car(String carName) {
        this.carName = carName;
        forwardCount = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void increaseForwardCount() {
        forwardCount++;
    }
}
