package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    static boolean isOverThresholdNum() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= Constant.THRESHOLD_NUMBER;
    }
}
