package racingcar.domain;

public class Car {
    private final String name;
    private final MovementStrategy movementStrategy = new RandomMovementStrategy();
    private final MovementHistory movementHistory = new MovementHistory();
    private final Round round;

    public Car(String name, Round round) {
        this.name = name;
        this.round = round;
    }

    public String getName() {
        return name;
    }

    public MovementHistory getMovementHistory() {
        return movementHistory;
    }

    public void move() {
        movementHistory.recordMovement(movementStrategy.couldMove());
        round.proceedToNextRound();
    }

    public boolean isWinner(int maxDistance) {
        return movementHistory.isMaxDistance(maxDistance);
    }

    public boolean isReachedFinalRound() {
        return round.hasReachedFinalRound();
    }
}
