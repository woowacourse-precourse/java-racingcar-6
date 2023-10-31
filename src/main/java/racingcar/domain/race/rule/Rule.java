package racingcar.domain.race.rule;

public class Rule {
    private final static int MOVING_FORWARD = 4;

    private Rule() {
    }

    public static Rule newInstance() {
        return new Rule();
    }

    public boolean isForward(final int accelerationValue) {
        return accelerationValue >= MOVING_FORWARD;
    }

}
