package racingcar.model;

public class Car {

    private final String name;
    private int location = 0;

    Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
