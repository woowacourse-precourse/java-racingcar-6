package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

// 0부터 9까지의 임의의 값을 생성하기 위한 클래스
public class NumberFactory {
    private final static int MIN_RANGE = 0;
    private final static int MAX_RANGE = 9;

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }

    private NumberFactory() {
    }
}