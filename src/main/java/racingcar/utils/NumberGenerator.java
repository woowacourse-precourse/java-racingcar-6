
package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    final static int START_INCURSIVE = 0;
    final static int END_INCURSIVE = 9;

    public static Integer generateRandNum(){
        return Randoms.pickNumberInRange(START_INCURSIVE, END_INCURSIVE);
    }
}
