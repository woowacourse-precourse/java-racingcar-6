package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    /**
     * 랜덤 숫자 생성
     */
    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }
}
