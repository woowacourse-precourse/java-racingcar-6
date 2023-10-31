package racingcar.model;

import static racingcar.validation.InputValidator.validateInputName;

import racingcar.constant.GameConfig;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void forward() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        validateInputName(name, GameConfig.MAXIMUM_CAR_NAME_LENGTH.getValue());
    }
}
