package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

/*
 * Car 랑 generateRandomNumber 는 관련이 없는거 같아서 나누었습니다.
 * */
public class RandomGenerator implements NumberGenerator {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    @Override
    public int generateNumber() {
        return generateRandomNumber();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
