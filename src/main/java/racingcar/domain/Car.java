package racingcar.domain;

public class Car {

    private String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public void moveForward(int value) {
        if (value >= 4) {
            forwardCount++;
        }
    }
}
