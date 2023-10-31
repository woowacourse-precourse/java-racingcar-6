package racingcar.model;

import racingcar.model.number.NumberGenerator;
import racingcar.validator.Validator;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private static final int MINIMUM_ADVANCE_NUMBER = 4;
    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public static Car createCar(String name) {
        validate(name);
        return new Car(name);
    }

    private static void validate(String name) {
        Validator.checkEmptyCarName(name);
        Validator.checkCarNameRange(name);
    }

    public void moveForward(NumberGenerator generator) {
        final int result = generator.generate();
        if (result >= MINIMUM_ADVANCE_NUMBER) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}