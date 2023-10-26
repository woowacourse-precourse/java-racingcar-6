package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class GeneratedRandomNumber {

    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;

    public static int getNumber(){
        return Randoms.pickNumberInRange(START_RANGE, END_RANGE);
    }
}
