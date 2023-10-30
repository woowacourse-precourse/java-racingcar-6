package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int generateNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
