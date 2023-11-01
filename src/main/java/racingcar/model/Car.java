package racingcar.model;


import static racingcar.constant.Constant.*;
import static racingcar.constant.ErrorMessage.INVALID_CAR_NAME_LENGTH;


public class Car {
    private String name;

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private int position;

    public Car(String name) {
        if (name.length() > MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }

        this.name = name;
    }

    public void move(int distance) {
        if (distance >= MOVE_THRESHOLD) position++;
    }

    public String getMovement() {
        StringBuilder movement = new StringBuilder();
        for (int i = 0; i < position; i++) movement.append('-');
        return movement.toString();
    }
}