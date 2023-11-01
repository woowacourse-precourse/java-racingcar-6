package racingcar.strategy;

import java.util.Arrays;
import java.util.Stack;

public class FakeRacingCarMoveStrategy implements RacingCarMoveStrategy {

    private final Stack<Boolean> stack;

    public FakeRacingCarMoveStrategy(Boolean... moves) {
        stack = new Stack<>() {{
            this.addAll(Arrays.stream(moves).toList());
        }};
    }

    @Override
    public boolean isMovable() {
        return stack.pop();
    }

}
