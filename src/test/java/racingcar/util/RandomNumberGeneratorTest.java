package racingcar.util;

public class RandomNumberGeneratorTest implements RandomGenerator {

    private int randomNumber;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private static final int CAN_MOVE_MIN_NUMBER = 4;

    public RandomNumberGeneratorTest() {
    }

    public RandomNumberGeneratorTest(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean isCanMove() {
        return randomNumber >= CAN_MOVE_MIN_NUMBER;
    }

}
