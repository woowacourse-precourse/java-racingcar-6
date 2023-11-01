package racingcar.model;

public class Car {
    private String name;
    private int forwardCount;

    public String getName() {
        return this.name;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }

    public Car(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public void go() {
        this.forwardCount++;
    }
}
