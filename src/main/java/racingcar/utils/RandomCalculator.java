package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCalculator {
    private static final Integer MIN_VALUE= 0;
    private static  final Integer MAX_VALUE= 9;


    public static boolean calRandom() {
        int num = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        if (num >= 4) {
            return true;
        }
        return false;
    }

}
