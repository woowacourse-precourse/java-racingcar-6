package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public final class NumberGenerator {

    private NumberGenerator() {
    }

    public static int generateRandomNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }

}
