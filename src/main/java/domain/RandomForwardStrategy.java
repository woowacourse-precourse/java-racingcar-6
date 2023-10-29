package domain;

import util.generator.RandomNumberGenerator;

public class RandomForwardStrategy implements ForwardStrategy<Integer>{

    private static final int MOVABLE_NUMBER = 4;

    @Override
    public boolean canMove(Integer randomNumber) {
        return randomNumber >= MOVABLE_NUMBER;
    }

}
