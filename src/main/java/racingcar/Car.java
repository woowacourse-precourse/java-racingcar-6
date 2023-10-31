package racingcar;

public class Car {

    private final String name;
    private int currentPosition;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        currentPosition++;
    }

    public int getCureentPosition() {
        return currentPosition;
    }
}
