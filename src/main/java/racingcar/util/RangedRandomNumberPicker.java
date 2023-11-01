package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RangedRandomNumberPicker {

    private final int start;
    private final int end;

    public RangedRandomNumberPicker(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int pickNumber() {
        return Randoms.pickNumberInRange(start, end);
    }
}
