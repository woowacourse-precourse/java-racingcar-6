package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;


public class RandomNumber {
    public static int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
