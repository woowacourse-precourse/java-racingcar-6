package racingcar;

public class Car {

    private final String name;
    private int position;

    public Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public void moveForward() {
        position++;
    }
}
