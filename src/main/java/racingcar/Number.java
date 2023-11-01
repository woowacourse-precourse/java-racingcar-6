package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    final int MIN_NUM = 0;
    final int MAX_NUM = 9;

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }
}
