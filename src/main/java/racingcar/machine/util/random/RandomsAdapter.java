package racingcar.machine.util.random;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomsAdapter implements RandomsProvider {
    @Override
    public int pickNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}

