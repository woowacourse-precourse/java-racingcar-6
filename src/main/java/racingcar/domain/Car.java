package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward () {
        position += 1;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}