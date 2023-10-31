package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberPicker {

    public static int pickRandomNumberInRange(final int lowerBound, final int upperBound) {
        return Randoms.pickNumberInRange(lowerBound, upperBound);
    }
}
