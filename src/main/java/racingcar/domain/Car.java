package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move() {
        this.location++;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}