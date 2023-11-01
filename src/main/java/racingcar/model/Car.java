package racingcar.model;

public class Car {

    public final String name;
    public int forwardCount = 0;

    public Car(String name, int forwardCount) {
        this.name = name;
        this.forwardCount = forwardCount;
    }

    public void goForward() {
        this.forwardCount += 1;
    }
}