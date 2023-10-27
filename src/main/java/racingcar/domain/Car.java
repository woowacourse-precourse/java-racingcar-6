package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.global.GameConfig.*;

public class Car {
    private static final Integer INITIAL_INTEGER = 0;
    private static final String DASH = "-";

    private final String name;
    private Integer score;

    // Car Constructor
    private Car(String name) {
        this.name = name;
        this.score = INITIAL_INTEGER;
    }

    // Car Static Factory Method
    public static Car create(final String name) {
        return new Car(name);
    }

    public void play() {
        Integer condition = generateForwardCondition();
        forwardCarByCondition(condition);
    }

    private void forwardCarByCondition(Integer condition) {
        if (isForwardCondition(condition)) {
            score++;
        }
    }

    public String generateResult() {
        String dashes = visualizeScoreToDashes();
        return String.format("%s : %s", name, dashes);
    }

    private String visualizeScoreToDashes() {
        return DASH.repeat(score);
    }


    private boolean isForwardCondition(Integer referencePoint) {
        return referencePoint >= NAME_MAXIMUM_CONSTRAINT.getValue();
    }

    private Integer generateForwardCondition() {
        return Randoms.pickNumberInRange(
                RANDOM_MINIMUM_CONSTRAINT.getValue(), RANDOM_MAXIMUM_CONSTRAINT.getValue());
    }
}
