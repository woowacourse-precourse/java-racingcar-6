package racingcar.domain;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public void move(int moveDistance) {
        distance += moveDistance;
    }

    String getName() {
        return name;
    }

    int getDistance() {
        return distance;
    }
}
