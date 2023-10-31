package racingcar.domain;

import static racingcar.Vars.LENGTH_CAR_NAME;
import static racingcar.Vars.MOVE_CONDITION;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > LENGTH_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름은 1~5자만 가능합니다.");
        }
    }

}
