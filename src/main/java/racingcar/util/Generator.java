package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Generator {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}