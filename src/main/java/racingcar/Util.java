package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Util {
    private final int START_RANGE = 0;
    private final int END_RANGE = 9;

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_RANGE, END_RANGE);
    }
}
