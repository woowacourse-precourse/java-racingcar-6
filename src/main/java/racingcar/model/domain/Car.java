package racingcar.model.domain;

public class Car {

    private final String name;

    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void increaseLocation() {
        this.location++;
    }
}