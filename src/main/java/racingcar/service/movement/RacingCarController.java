package racingcar.service.movement;

import java.util.stream.IntStream;

public class RacingCarController {
    private final MovementStrategy movementStrategy;

    public RacingCarController(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public void moveCars(int[] countsByName) {
        IntStream.range(0, countsByName.length)
                .filter(t -> movementStrategy.shouldMove())
                .forEach(t -> countsByName[t]++);
    }

    public interface MovementStrategy {
        boolean shouldMove();
    }
}




