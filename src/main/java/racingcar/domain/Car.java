package racingcar.domain;

import static racingcar.exception.CarNameException.*;

public class Car {
    private final static int CAR_MOVABLE_MIN_NUMBER = 4;
    private final String name;

    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateCarNameLength(name);
        validateCarNameBlank(name);
        validateCarNameEmpty(name);
        validateCarNameEng(name);
    }

    public void move(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generate();

        if (number >= CAR_MOVABLE_MIN_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
