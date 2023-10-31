package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.input.ValidateInput;

class RandomNumber {
    private final int start;
    private final int end;

    private RandomNumber(Integer start, Integer end) {
        ValidateInput.validateIntegerRange(start, end);
        this.start = start;
        this.end = end;
    }

    public static RandomNumber fromInteger(Integer start, Integer end) {
        return new RandomNumber(start, end);
    }

    public int pickNumber() {
        return Randoms.pickNumberInRange(start, end);
    }
}
