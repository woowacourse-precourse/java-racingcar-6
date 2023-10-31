package domain;

import util.generator.RandomNumberGenerator;

public class RandomMoveJudgement implements MoveJudgement {

    private static final int MOVABLE_NUMBER = 4;

    @Override
    public boolean canMove() {
        return RandomNumberGenerator.generateRandomNumber() >= MOVABLE_NUMBER;
    }

}
