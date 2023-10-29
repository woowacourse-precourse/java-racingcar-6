package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public static boolean isConditionsAdvancementMet() {
        int number = Randoms.pickNumberInRange(0,9);
        return number >= 4;
    }
}
