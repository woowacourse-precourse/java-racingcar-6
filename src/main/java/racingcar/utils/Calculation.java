package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Calculation {
    public static int createRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
