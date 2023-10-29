package racingcar.domain;

public class Car {
    private int forwardCount;
    private final String name;

    public Car(String name) {
        this.forwardCount = 0;
        this.name = name;
    }

    public void moveForward() {
        this.forwardCount++;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
