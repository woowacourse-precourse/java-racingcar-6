package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber implements RandomUtil{
    @Override
    public int generate(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
