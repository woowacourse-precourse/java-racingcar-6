package racingcar.model;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
