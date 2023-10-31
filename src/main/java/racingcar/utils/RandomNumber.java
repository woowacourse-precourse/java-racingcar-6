package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static int generator() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}
