package racingcar.domain;

import static racingcar.configuration.StartingPositionConfig.START_POSITION;
import static racingcar.constant.ErrorMessage.CAR_LENGTH_EXCESS_EXCEPTION;

public class Car {

    private String name;
    private int position;

    public Car(String name, int position) {
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

}
