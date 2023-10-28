package racingcar.model;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void increaseDistance() {
        this.distance++;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}