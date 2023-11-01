package racingcar.mock;

import racingcar.util.Random;

public class MockRandom extends Random {
    private int[] numbers;
    private int position;

    public int getRandomNumberInRange(int min, int max) {
        return numbers[position++];
    }

    public void setRandomNumber(int... randomNumbers) {
        numbers = randomNumbers;
    }
}
