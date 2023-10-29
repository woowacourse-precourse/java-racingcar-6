package racingcar;

public class Car {
    private String name;
    private int movingCount = 0;

    public Car(final String carName) {
        name = carName;
    }

    public void moveForward() {
        movingCount++;
    }

    public String toString() {
        StringBuilder movingMark = new StringBuilder();
        movingMark.append("-".repeat(Math.max(0, movingCount)));

        return "name : " + movingMark;
    }
}
