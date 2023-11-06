package racingcar.model.movingstrategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RangedRandomNumberPicker {

    private final int randomRangeStart;
    private final int randomRangeEnd;

    public RangedRandomNumberPicker(int randomRangeStart, int randomRangeEnd) {
        this.randomRangeStart = randomRangeStart;
        this.randomRangeEnd = randomRangeEnd;
    }

    public int pickNumber() {
        return Randoms.pickNumberInRange(randomRangeStart, randomRangeEnd);
    }
}
