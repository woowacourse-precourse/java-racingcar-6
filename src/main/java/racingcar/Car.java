package racingcar;

public class Car {
    private final String name;

    private int position = 0;

    Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }
}
