package racingcar.domain;

import racingcar.message.ErrorMessage;

import static racingcar.domain.GameOption.*;

public class Car{
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name){
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        validateBlank(name);
        validateNameLength(name);
    }

    private static void validateNameLength(String name) {
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.EXCESS_NAME_LENGTH_LIMIT);
        }
    }

    private static void validateBlank(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME);
        }
    }

    public void moveForward() {
        position++;
    }

    @Override
    public String toString() {
        return name + " : " + CAR_POSITION_SIGN.repeat(position);
    }
}
