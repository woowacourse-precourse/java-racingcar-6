package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RangedRandomNumberPicker {

    private final Range randomNumberRange;

    public RangedRandomNumberPicker(Range randomNumberRange) {
        this.randomNumberRange = randomNumberRange;
    }

    public int pickNumber() {
        return Randoms.pickNumberInRange(randomNumberRange.start(), randomNumberRange.end());
    }
}
