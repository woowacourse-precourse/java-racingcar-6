package racingcar.domain;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int move() {
        distance += 1;
        return distance;
    }
}
