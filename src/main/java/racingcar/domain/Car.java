package racingcar.domain;

import static racingcar.configuration.InputFormatConfig.MAX_LENGTH_OF_CAR_NAME;
import static racingcar.configuration.StartPositionConfig.START_POSITION;
import static racingcar.constant.ErrorMessage.CAR_NAME_LENGTH_EXCESS_EXCEPTION;

public class Car {

    private String name;
    private int position;

    public Car(String name, int position) {
        validateLengthOfName(name);
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        return new Car(name, START_POSITION);
    }

    public void move(int index) {
        if (index < 4) {
            return;
        }

        ++position;
    }

    private void validateLengthOfName(String name) {
        if (name.length() <= MAX_LENGTH_OF_CAR_NAME) {
            return;
        }

        throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCESS_EXCEPTION);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
