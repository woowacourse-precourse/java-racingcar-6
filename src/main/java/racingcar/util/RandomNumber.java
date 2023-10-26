package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public static boolean canMove(int number) {
        return number >= 4;
    }
}
