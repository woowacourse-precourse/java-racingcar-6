package racingcar.domain;

import racingcar.util.CarGoingRandomNumber;
import racingcar.util.NumberGenerator;

public class RandomMovingStrategy implements MovingStrategy {
    private final int MIN_MOVABLE_NUMBER = 4;
    private final int MIN_CAR_NUMBER = 0;
    private final int MAX_CAR_NUMBER = 9;

    @Override
    public boolean movable() {
        return getRandomNo() >= MIN_MOVABLE_NUMBER;
    }

    private int getRandomNo() {
        NumberGenerator randomNumberGenerator = new CarGoingRandomNumber();
        return randomNumberGenerator.generateRandomNumber(MIN_CAR_NUMBER, MAX_CAR_NUMBER);
    }
}
