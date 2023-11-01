package racingcar.model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        position += 1;
    }

    public String getName() {
        return name;
    }

    public int genPosition() {
        return position;
    }
}

