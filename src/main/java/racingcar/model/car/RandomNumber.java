package racingcar.model.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber implements RandomUtil {
    @Override
    public Integer generate(Integer minBound, Integer maxBound) {
        return Randoms.pickNumberInRange(minBound, maxBound);
    }
}
