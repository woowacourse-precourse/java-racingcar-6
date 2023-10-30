package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

// 0부터 9까지의 임의의 값을 생성하기 위한 클래스
public class NumberFactory {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private NumberFactory() {
    }
}