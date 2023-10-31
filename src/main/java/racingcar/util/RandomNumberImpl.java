package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberImpl implements RandomNumber {
    @Override
    public int randomGenerate(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
