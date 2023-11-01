package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {
    private static final int START_NUM = 0;
    private static final int END_NUM = 9;

    static public int getRandomNumber(){
        return Randoms.pickNumberInRange(START_NUM, END_NUM);
    }
}
