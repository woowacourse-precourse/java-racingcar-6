package racingcar.domain;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isEqualDistance(int compareDistance) {
        return distance == compareDistance;
    }

    public void go() {
        distance++;
    }
}