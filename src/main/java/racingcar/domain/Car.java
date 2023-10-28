package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

import static racingcar.configuration.GameConfiguration.RANDOM_MAXIMUM_CONSTRAINT;
import static racingcar.configuration.GameConfiguration.RANDOM_MINIMUM_CONSTRAINT;

public class Car {
    private static final Integer FORWARD_BOUNDARY_CONDITION = 4;
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

    public void move() {
        Integer precondition = generatePrecondition();
        moveByCondition(precondition);
    }

    private void moveByCondition(Integer precondition) {
        if (isForwardCondition(precondition)) {
            score++;
        }
    }

    public String generateRoundResult() {
        String dashes = convertScoreToDashes();
        return String.format("%s : %s", name.getName(), dashes);
    }

    private String convertScoreToDashes() {
        return DASH.repeat(score);
    }

    private boolean isForwardCondition(final Integer referencePoint) {
        return referencePoint >= FORWARD_BOUNDARY_CONDITION;
    }

    private Integer generatePrecondition() {
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
