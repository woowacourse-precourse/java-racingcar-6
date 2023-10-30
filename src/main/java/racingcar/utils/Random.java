package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public static int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean isConditionsAdvancementMet(int number) {
        return number >= 4;
    }
}
