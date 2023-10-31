package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int MIN = 0;
    private static final int MAX = 9;

    public boolean isNumberThanEqualFour() { //Distance 업데이트
        if (makeRandomNumber() >= 4) {
            return true;
        }
        return false;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }

}
