package racingcar.domain;

public class Car {

    private String name;
    private int straightCount;

    public Car(String name) {
        this.name = name;
        this.straightCount = 0;
    }

    public void goStraight() {
        this.straightCount++;
    }

    public String getName() {
        return name;
    }

    public int getStraightCount() {
        return straightCount;
    }
}
