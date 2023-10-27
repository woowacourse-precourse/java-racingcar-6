package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberCreator {
    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
