package racingcar;

public class Car {

    private final String name;
    private int location;

    public Car (String name) {
        this.name = name;
        this.location = 0;
    }

    void moveForward() {
        location++;
    }

    String getName() {
        return name;
    }

    int getLocation() {
        return location;
    }
}
