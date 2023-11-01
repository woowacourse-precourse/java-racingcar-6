package number;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberPicker implements NumberPicker {
    private static final int DEFAULT_START_INCLUSIVE = 0;
    private static final int DEFAULT_END_INCLUSIVE = 9;

    public RandomNumberPicker() {
    }

    // 추후 필요성이 생길 경우 외부에서 startInclusive, endInclusive 주입할 수 있도록 변경

    @Override
    public int pick() {
        return Randoms.pickNumberInRange(DEFAULT_START_INCLUSIVE, DEFAULT_END_INCLUSIVE);
    }
}
