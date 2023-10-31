package model;

public class Car {
    static final char ADD_BY = '-';

    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        this.distance += 1;
    }

    @Override
    public String toString() {
        String carState = (this.name + " : ");

        for (int i = 0; i < this.distance; i++) {
            carState += ADD_BY;
        }

        return carState;
    }
}
