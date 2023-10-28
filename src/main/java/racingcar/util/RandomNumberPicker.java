package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberPicker implements NumberPicker {
    private final int startInclusive;
    private final int endInclusive;

    public RandomNumberPicker(int startInclusive, int endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    @Override
    public int pick() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
