package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private NumberGenerator() {
    }

    public static int generateRandom() {
        int startInclusive = 0;
        int endInclusive = 9;
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
