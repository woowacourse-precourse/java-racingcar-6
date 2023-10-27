package racingcar.domain;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_THRESHOLD = 4;
    private final int randomNumber;

    public RandomMoveStrategy(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean isMovable() {
        return randomNumber >= MOVE_THRESHOLD;
    }
}
