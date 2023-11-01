package racingcar.domain.car;

import racingcar.domain.movement.MovementHistory;
import racingcar.domain.movement.MovementStrategy;
import racingcar.domain.round.Round;

public class Car {
    private final String name;
    private final MovementStrategy movementStrategy;
    private final MovementHistory movementHistory = new MovementHistory();
    private final Round round;

    public Car(String name, MovementStrategy movementStrategy, Round round) {
        this.name = name;
        this.movementStrategy = movementStrategy;
        this.round = round;
    }

    public String getName() {
        return name;
    }
    public MovementHistory getMovementHistory() {
        return movementHistory;
    }

    public void processRound() {
        boolean couldMove = movementStrategy.couldMove();
        movementHistory.recordMovement(couldMove);
        proceedToNextRound();
    }
    private void proceedToNextRound() {
        round.proceedToNextRound();
    }

    public boolean hasReachedMaxDistance(int maxDistance) {
        return movementHistory.isMaxDistance(maxDistance);
    }
    public boolean hasReachedFinalRound() {
        return round.hasReachedFinalRound();
    }
}
