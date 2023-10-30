package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class RandomMovable implements Movable {

    public static final int MIN_NUMBER_FORWARD_CONDITION = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomMovable(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean canMove() {
        int number = randomNumberGenerator.generate();

        return number >= MIN_NUMBER_FORWARD_CONDITION;
    }
}
