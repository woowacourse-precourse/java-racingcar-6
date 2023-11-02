package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private final int minRandomNum;
    private final int maxRandomNum;

    public RandomNumberGenerator(int minRandomNum, int maxRandomNum) {
        this.minRandomNum = minRandomNum;
        this.maxRandomNum = maxRandomNum;
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(minRandomNum, maxRandomNum);
    }
}

