package racingcar;

public class Car {
    private final String name;
    private int movingCount;

    public Car(String name) {
        this.name = name;
        this.movingCount = 0;
    }

    public void addOneMovingCount() {
        movingCount++;
    }
}
