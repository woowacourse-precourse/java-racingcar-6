package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private final int START_INCLUSIVE;
    private final int END_INCLUSIVE;
    public RandomNumberGenerator(int start, int end) {
        START_INCLUSIVE = start;
        END_INCLUSIVE = end;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
