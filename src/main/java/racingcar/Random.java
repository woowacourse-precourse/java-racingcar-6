package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    static boolean isNumOverFour() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= 4;
    }
}
