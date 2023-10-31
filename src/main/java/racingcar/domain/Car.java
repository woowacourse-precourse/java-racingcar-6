package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.global.Validation;

public class Car {

    private static final int MIN_VALUE = 4;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 9;

    private final String name;
    private int position;

    private Car(String name) {
        Validation.validateName(name);
        this.name = name;
        this.position = 0;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
