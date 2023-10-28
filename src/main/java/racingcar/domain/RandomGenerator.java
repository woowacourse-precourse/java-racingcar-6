package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    // 0 ~ 9 랜덤 값을 반환한다.
    public static int generate() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random;
    }
}
