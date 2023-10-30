package racingcar.domain.track;

public class Rule {
    private final static int MOVING_FORWARD = 4;

    private Rule() {
    }

    public Rule newInstance() {
        return new Rule();
    }

    public boolean isForward(final int accelerationValue) {
        return accelerationValue >= MOVING_FORWARD;
    }

}
