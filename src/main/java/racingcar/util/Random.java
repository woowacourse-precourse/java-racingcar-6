package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public static boolean check(){
        int r = Randoms.pickNumberInRange(0, 9);
        return r >= 4;
    }
}
