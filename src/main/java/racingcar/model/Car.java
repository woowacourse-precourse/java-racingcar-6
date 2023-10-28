package racingcar.model;

import static racingcar.exception.CarNameValidator.validateCarName;

public class Car {

    private static final Integer INIT_STEP = 0;

    private final String name;
    private Integer step;

    public Car(final String name) {
        validateCarName(name);
        this.name = name;
        this.step = INIT_STEP;
    }

    public void move() {
        this.step = Status.moveOrStop() + this.step;
    }

    public String getName() {
        return name;
    }

    public Integer getStep() {
        return step;
    }
}