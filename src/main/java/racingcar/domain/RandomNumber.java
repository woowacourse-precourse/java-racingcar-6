package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber implements RandomUtil {
    @Override
    public int generate(int low, int high) {
        return Randoms.pickNumberInRange(low, high);
    }
}
