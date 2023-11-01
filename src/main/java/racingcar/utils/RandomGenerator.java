package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;


public class RandomGenerator implements NumberGenerator {

    private final static int START_INCLUSIVE = 0;
    private final static int END_INCLUSIVE = 9;

    @Override
    public int generate() {
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        checkValidation(randomNumber);
        return randomNumber;

    }

    private void checkValidation(int randomNumber) {
        if (randomNumber < START_INCLUSIVE || randomNumber > END_INCLUSIVE) {
            throw new IllegalArgumentException();
        }
    }
}