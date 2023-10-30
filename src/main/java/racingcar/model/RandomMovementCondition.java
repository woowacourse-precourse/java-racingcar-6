package racingcar.model;

public class RandomMovementCondition implements MovementCondition {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_MOVABLE_NUMBER = 4;
    private static final int MAX_MOVABLE_NUMBER = 9;

    private final NumberGenerator numberGenerator;

    public RandomMovementCondition(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isMovable() {
        int randomNumber = numberGenerator.generateBetween(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return randomNumber >= MIN_MOVABLE_NUMBER && randomNumber <= MAX_MOVABLE_NUMBER;
    }
}
