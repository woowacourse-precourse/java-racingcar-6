package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private RandomNumber() {}

    public static Integer makeRandomNumber() {
        Integer randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}
