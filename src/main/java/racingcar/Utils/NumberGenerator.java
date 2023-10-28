package racingcar.Utils;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int getRandomNumberFromZeroToNine() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
