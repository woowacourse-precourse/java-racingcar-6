package domain;

import java.util.Random;

public class RandomNumberStrategy {
    private static final int FORWARD_JUDGEMENT_NUMBER = 3;
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    public boolean isMoveforward() {
        return getRandomNumber() > FORWARD_JUDGEMENT_NUMBER;
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
