package racingcar.model;

public class Car {
    private final String name;
    private int currentLocation;

    public Car(String name, int currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void moveForward() {
        currentLocation += 1;
    }
}
