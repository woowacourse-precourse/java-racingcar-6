package racingcar.Generator;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public boolean isFourOrAbove(int number) {
        if (number >= 4) {
            return true;
        }
        return false;
    }

}
