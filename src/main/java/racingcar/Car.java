package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
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

