package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

/* Random 생성기
*  0 ~ 9*/
public class RandomGenerator {
    private final int MIN_FORWARD_NUMBER = 4;

    // random 생성
    public int generateRandom() {
        return Randoms.pickNumberInRange(0,9);
    }

    // random 결과가 4이상이면 true
    public boolean isForward() {
        return generateRandom() >= MIN_FORWARD_NUMBER;
    }
}
