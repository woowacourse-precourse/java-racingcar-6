package racingcar;

public class Car {
    private String carName;
    private boolean forwardBool = false;
    private int forwardCount = 0;

    Car(String carName) {
        this.carName = carName;
    }

    public void setforwardBool(boolean forwardBool) {
        this.forwardBool = forwardBool;
    }

    public void addForwardCount() {
        this.forwardCount++;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }
}
