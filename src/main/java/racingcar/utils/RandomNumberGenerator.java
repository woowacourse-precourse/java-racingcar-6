package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private final int START_NUMBER = 0;
    private final int END_NUMBER = 9;

    public Integer randomNumberGenerate() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
