package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public void plusMoveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
