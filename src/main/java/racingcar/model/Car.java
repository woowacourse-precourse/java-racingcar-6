package racingcar.model;

public class Car {
    private final String name;
    private int distance;
    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public void moveForward() {
        distance += 1;
    }

    public String getName() {
        return name;
    }
    public int getDistance() {
        return distance;
    }
}
