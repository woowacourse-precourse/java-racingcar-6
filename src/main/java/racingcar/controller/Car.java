package racingcar.controller;

public class Car {

    private String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move() {
        this.distance += 1;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name + ": " + distance;
    }


}
