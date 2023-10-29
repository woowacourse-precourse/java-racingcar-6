package racingcar.model.domain;

public class Car {
    private final String name;
    private int location = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void move() {
        location += 1;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
