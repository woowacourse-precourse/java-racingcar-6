package racingcar.domain;

public class Car {

    private String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public int moveForward(int value) {
        if (value >= 4) {
            forwardCount++;
        }
        return forwardCount;
    }

    public int getLargerForwardCount(int maxForwardCount) {
        return Math.max(forwardCount, maxForwardCount);
    }

    public boolean isSameAs(int forwardCount) {
        return this.forwardCount == forwardCount;
    }

    public String getName() {
        return name;
    }
}
