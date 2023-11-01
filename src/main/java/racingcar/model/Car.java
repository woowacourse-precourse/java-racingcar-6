package racingcar.model;

public class Car {
    private String name;
    private int distance;

    public Car() {
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void addDistance() {
        this.distance++;
    }
}
