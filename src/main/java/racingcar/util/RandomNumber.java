package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static int MININUM_NUMBER = 0;
    private static int MAXIMUM_NUMBER = 9;

    private RandomNumber(){ }

    public static Integer getNumber() {
        return Randoms.pickNumberInRange(MININUM_NUMBER, MAXIMUM_NUMBER);
    }
}
