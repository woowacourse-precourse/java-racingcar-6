package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.global.GameConfig.RANDOM_MAXIMUM_CONSTRAINT;
import static racingcar.global.GameConfig.RANDOM_MINIMUM_CONSTRAINT;

public class Car {
    private static final Integer INITIAL_INTEGER = 0;

    private final String name;
    private final Integer score;

    // Car Constructor
    private Car(String name) {
        this.name = name;
        this.score = INITIAL_INTEGER;
    }

    // Car Static Factory Method
    public static Car create(final String name) {
        return new Car(name);
    }

    public static void play() {
        Integer referencePoint = generateForwardCondition();
    }

    private static Integer generateForwardCondition() {
        return Randoms.pickNumberInRange(
                RANDOM_MINIMUM_CONSTRAINT.getValue(), RANDOM_MAXIMUM_CONSTRAINT.getValue());
    }
}
