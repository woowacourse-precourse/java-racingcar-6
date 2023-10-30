package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomManipulator {
    public static boolean isMove() {
        int randNum = Randoms.pickNumberInRange(0, 9);

        return randNum >= 4;
    }
}
