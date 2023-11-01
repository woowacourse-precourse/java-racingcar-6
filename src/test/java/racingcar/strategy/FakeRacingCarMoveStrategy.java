package racingcar.strategy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class FakeRacingCarMoveStrategy implements RacingCarMoveStrategy {

    private final Queue<Boolean> queue;

    public FakeRacingCarMoveStrategy(Boolean... moves) {
        queue = new LinkedList<>(Arrays.stream(moves).toList());
    }

    @Override
    public boolean isMovable() {
        final var result = queue.poll();
        Objects.requireNonNull(result);
        return result;
    }

}
