package racingcar.domain.car;

import java.util.function.Function;

public enum SupportedMove {

    MOVE(moveCount -> moveCount + 1),
    STOP(moveCount -> moveCount);

    private Function<Integer, Integer> expression;

    SupportedMove(Function<Integer, Integer> expression) {
        this.expression = expression;
    }

    public int calculate(int value) {
        return expression.apply(value);
    }

}
