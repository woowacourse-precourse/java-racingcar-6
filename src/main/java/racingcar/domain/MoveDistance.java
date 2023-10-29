package racingcar.domain;

import racingcar.constant.ProgressMessage;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class MoveDistance {

    private static final int INITIAL_VALUE = 0;
    private static final int PLUS_UNIT = 1;
    private final Integer value;

    public MoveDistance() {
        this.value = INITIAL_VALUE;
    }

    private MoveDistance(final MoveDistance moveDistance) {
        this.value = moveDistance.value + PLUS_UNIT;
    }

    public MoveDistance next() {
        return new MoveDistance(this);
    }

    public int toValue() {
        return this.value;
    }

    public String toResultMessage() {
        return Stream.generate(ProgressMessage.MOVE_EXPRESSION::toValue)
                .limit(value)
                .collect(Collectors.joining());
    }
}
