package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNum {
    final static int START_NUMBER = 1;
    final static int LAST_NUMBER = 9;

    public static int number() {
        return Randoms.pickNumberInRange(START_NUMBER, LAST_NUMBER);
    }
}
