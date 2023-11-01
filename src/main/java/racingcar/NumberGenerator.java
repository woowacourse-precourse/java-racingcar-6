package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private final int minRange;
    private final int maxRange;

    public NumberGenerator(int minRange, int maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public int randomNumber() {
        return Randoms.pickNumberInRange(minRange, maxRange);
    }
}
