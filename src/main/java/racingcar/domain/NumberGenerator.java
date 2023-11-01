package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    public static int generateNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

}
