package racingcar.domain.car;

import racingcar.domain.car.validate.NameLengthValidator;

public class Car {

    private static final int START_LOCATION = 0;
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private Integer location;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.location = START_LOCATION;
    }

    public Integer getLocation() {
        return location;
    }

    public void move(Integer commandNumber) {
        if (commandNumber >= MOVE_CONDITION) {
            this.location++;
        }
    }

    private void validate(String name) {
        NameLengthValidator.validate(name);
    }
}
