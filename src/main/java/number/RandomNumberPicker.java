package number;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberPicker implements NumberPicker {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    @Override
    public int pick() {
        return Randoms.pickNumberInRange(
                START_INCLUSIVE,
                END_INCLUSIVE
        );
    }
}
