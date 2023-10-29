package racingcar.domain.game.move;

import racingcar.util.MoveStrategy;
import racingcar.util.NumberGenerator;

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
