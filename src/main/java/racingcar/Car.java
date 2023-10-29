package racingcar;

public class Car {
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        location = 0;
    }

    public void moveForward() {
        location++;
    }

    @Override
    public String toString() {
        String currentLocation = "-".repeat(location);
        return name + " : " + currentLocation;
    }
}
