package racingcar.domain;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void updateDistance(int addMoving) {
        this.distance = distance + addMoving;
    }

    public int getDistance() {
        return distance;
    }
}