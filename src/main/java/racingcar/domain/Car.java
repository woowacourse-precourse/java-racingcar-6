package racingcar.domain;

import racingcar.manager.Validator;
import static racingcar.Vars.MOVE_CONDITION;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        Validator.validateCarNameLength(name);
        this.name = name;
        this.position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
