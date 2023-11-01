package racingcar.domain;

public class Car {

    private final String name;
    private int currentPosition;

    public Car(String name) {
        this.name = name;
    }

    public int moveForward(boolean isSuccessForward) {
        if (isSuccessForward) {
            currentPosition++;
        }
        return currentPosition;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
