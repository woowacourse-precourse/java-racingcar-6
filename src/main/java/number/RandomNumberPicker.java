package number;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberPicker implements NumberPicker {
    private static final int DEFAULT_START_INCLUSIVE = 0;
    private static final int DEFAULT_END_INCLUSIVE = 9;
    private final int startInclusive = DEFAULT_START_INCLUSIVE;
    private final int endInclusive = DEFAULT_END_INCLUSIVE;

    public RandomNumberPicker() {
    }

    @Override
    public int pick() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
