package racingcar.move;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int THRESHOLD = 4;
    private final NumberGenerator numberGenerator;

    public RandomMoveStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isMovable() {
        int randomNumber = numberGenerator.generateNumber();
        return randomNumber >= THRESHOLD;
    }
}
