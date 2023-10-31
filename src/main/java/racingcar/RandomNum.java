package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.NoSuchElementException;

public class RandomNum {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    public int createRandomNum() {
        int randomNumber;

        try {
            randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        }
        catch (NoSuchElementException e) {
            throw e;
        }

        return randomNumber;
    }
}
