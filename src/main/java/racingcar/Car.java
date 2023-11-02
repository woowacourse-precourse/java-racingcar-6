package racingcar;

public class Car {
    private String carName;
    private int forwardCount = 0;

    Car(String carName) {
        this.carName = carName;
    }

    public void addForwardCount() {
        this.forwardCount++;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }
}
