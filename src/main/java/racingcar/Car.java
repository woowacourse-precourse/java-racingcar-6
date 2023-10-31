package racingcar;

public class Car {

    private final String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
        forwardCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void moveForward() {
        forwardCount++;
    }

}
