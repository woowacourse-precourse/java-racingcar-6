package racingcar.domain;

public class Car {
    private final String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void rush() {
        location++;
    }
}
