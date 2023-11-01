package racingcar.domain;

import racingcar.validation.InputFormatValidator;

import static racingcar.configuration.StartPositionConfig.START_POSITION;

public class Car {

    private String name;
    private int position;

    public Car(String name, int position) {
        InputFormatValidator.validateLengthOfName(name);
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

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
