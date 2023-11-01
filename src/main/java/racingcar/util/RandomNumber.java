package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static final int MIN_Number = 0;
    public static final int MAX_Number = 9;

    public int get() {
        return Randoms.pickNumberInRange(MIN_Number, MAX_Number);
    }
}
