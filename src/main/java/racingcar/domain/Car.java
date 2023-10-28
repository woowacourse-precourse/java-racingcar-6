package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

import static racingcar.configuration.GameConfiguration.*;

public class Car {
    private static final Integer START_SCORE = 0;
    private static final String DASH = "-";

    private final CarName name;
    private Integer score;

    // Car Constructor
    private Car(final String name) {
        this.name = CarName.create(name);
        this.score = START_SCORE;
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
        return String.format("%s : %s", name.getName(), dashes);
    }

    private String visualizeScoreToDashes() {
        return DASH.repeat(score);
    }

    private boolean isForwardCondition(final Integer referencePoint) {
        return referencePoint >= FORWARD_CONDITION.getValue();
    }

    private Integer generateForwardCondition() {
        return Randoms.pickNumberInRange(
                RANDOM_MINIMUM_CONSTRAINT.getValue(), RANDOM_MAXIMUM_CONSTRAINT.getValue());
    }

    public boolean isSameScore(Integer score) {
        return Objects.equals(this.score, score);
    }


    public Integer getScore() {
        return score;
    }

    public String getName() {
        return name.getName();
    }
}
