package racingcar.domain.car;

import java.util.function.Function;

public enum SupportedMove {

    MOVE(moveCount -> moveCount + 1),
    STOP(moveCount -> moveCount);

    private static final int MOVE_VALUE = 4;

    private Function<Integer, Integer> expression;

    SupportedMove(Function<Integer, Integer> expression) {
        this.expression = expression;
    }

    private int calculate(int value) {
        return expression.apply(value);
    }

    public static int controlMovement(int moveCount, int controlValue) {
        if (controlValue >= MOVE_VALUE) {
            return MOVE.calculate(moveCount);
        }
        return STOP.calculate(moveCount);
    }

}
