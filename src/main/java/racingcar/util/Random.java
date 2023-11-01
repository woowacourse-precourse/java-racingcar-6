package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    public static int make(int a, int b){
        return Randoms.pickNumberInRange(a, b);
    }

    public static boolean check(int r){
        return r >= 4;
    }
}
