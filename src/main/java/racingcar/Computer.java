package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public static int getNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
