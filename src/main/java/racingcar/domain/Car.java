package racingcar.domain;

public class Car {
    private final String name;
    private int movingCount = 0;

    public Car(final String carName) {
        name = carName;
    }

    public void moveForward() {
        movingCount++;
    }

    public String getCarName() {
        return name;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public String status() {
        return name + " : " + "-".repeat(movingCount);
    }
}
