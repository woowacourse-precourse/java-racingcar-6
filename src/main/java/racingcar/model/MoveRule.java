package racingcar.model;

import racingcar.util.RandomNumberGenerator;

public class MoveRule {
    private final int MOVE_CONDITION = 4;
    private int randomNumber;

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public boolean shouldMove() {
        randomNumber = randomNumberGenerator.getRandomNumber();
        return randomNumber >= MOVE_CONDITION;
    }

}
