package racingcar.model;

public class Car {
    private String name;
    private int distance;

    Car(String name, int distance) {
        name = this.name;
        distance = this.distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
