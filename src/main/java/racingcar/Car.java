package racingcar;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    private int position;

    public String getName() {
        return name;
    }

    void move() {
        this.position++;
    }
}
