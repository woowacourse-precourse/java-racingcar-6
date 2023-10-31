package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberPicker {

    public static int pickNumber(final int lowerBound, final int upperBound) {
        return Randoms.pickNumberInRange(lowerBound, upperBound);
    }
}
