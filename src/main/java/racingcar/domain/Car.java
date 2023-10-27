package racingcar.domain;

public class Car {
    private final String name;
    private int moveDistance;

    public Car(String name) {
        if (!nameLengthCheck(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.moveDistance = 0;
    }

    public String getName() {
        return this.name;
    }

    public void forward() {
        moveDistance++;
    }

    public String currentLocation() {
        StringBuilder location = new StringBuilder(name + " : ");
        location.append("-".repeat(Math.max(0, moveDistance)));
        return location.toString();
    }

    public int distance() {
        return moveDistance;
    }

    private boolean nameLengthCheck(String name) {
        return name.length() <= 5;
    }
}
