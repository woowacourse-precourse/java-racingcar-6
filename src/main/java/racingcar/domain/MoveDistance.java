package racingcar.domain;

import racingcar.constant.ProgressMessage;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class MoveDistance {

    private static final int START_INDEX = 0;
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
        return IntStream.range(START_INDEX, value)
                .mapToObj(element -> ProgressMessage.MOVE_EXPRESSION.toValue())
                .collect(Collectors.joining());
    }
}
