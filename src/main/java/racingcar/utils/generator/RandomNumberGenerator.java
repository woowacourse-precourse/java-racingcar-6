package racingcar.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator{

    @Override
    public int generate(int startOfRange, int endOfRange) {
        return Randoms.pickNumberInRange(startOfRange, endOfRange);
    }
}
