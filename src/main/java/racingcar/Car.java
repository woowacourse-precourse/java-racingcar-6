package racingcar;

public class Car {
    private static final int defaultPosition = 0;

    private String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = Car.defaultPosition;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }
}
