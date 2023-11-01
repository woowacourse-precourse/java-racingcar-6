package racingcar;

import static racingcar.Application.MOVING_CONDITION;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void Move(int randomNumber) {
        if (randomNumber >= MOVING_CONDITION) {
            moveForward();
        }
    }

    private void moveForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}