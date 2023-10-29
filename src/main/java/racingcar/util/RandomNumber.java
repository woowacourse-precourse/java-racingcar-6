package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private RandomNumber() {}

    public static int makeRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}
