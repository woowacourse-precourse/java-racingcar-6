package racingcar.model;

public class Car {
    private String name;

    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void moveForward() {
        this.location++;
    }
}
