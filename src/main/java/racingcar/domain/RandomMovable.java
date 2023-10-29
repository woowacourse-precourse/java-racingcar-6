package racingcar.domain;

import racingcar.util.Constants;
import racingcar.util.RandomNumberGenerator;

public class RandomMovable implements Movable {

    private final RandomNumberGenerator randomNumberGenerator;

    public RandomMovable(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean canMove() {
        int number = randomNumberGenerator.generate();

        return number >= Constants.MIN_NUMBER_FORWARD_CONDITION;
    }
}
