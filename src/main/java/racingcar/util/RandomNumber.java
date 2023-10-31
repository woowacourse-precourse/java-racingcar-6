package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

abstract public class RandomNumber {
    public static Integer createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
