package racingcar.model;

public class RandomMovementCondition implements MovementCondition {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVE_CONDITION = 4;

    private final NumberGenerator numberGenerator;

    public RandomMovementCondition(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isMovable() {
        int randomNumber = numberGenerator.generateBetween(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return randomNumber >= MOVE_CONDITION;
    }
}
