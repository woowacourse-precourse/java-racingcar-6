package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementCondition {
    public static final Integer FORWARD_MOVEMENT_LOWER_BOUND_CONDITION = 4;
    public static final Integer NUMBER_LOWER_BOUND_CONSTRAINT = 0;
    public static final Integer NUMBER_UPPER_BOUND_CONSTRAINT = 9;

    private final Integer condition;

    private MovementCondition() {
        this.condition = generateMovementCondition();
    }

    public static MovementCondition create() {
        return new MovementCondition();
    }

    public boolean canMovable() {
        return condition >= FORWARD_MOVEMENT_LOWER_BOUND_CONDITION;
    }

    private Integer generateMovementCondition() {
        return Randoms.pickNumberInRange(NUMBER_LOWER_BOUND_CONSTRAINT, NUMBER_UPPER_BOUND_CONSTRAINT);
    }

}
