package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public static boolean isMove(int randomNumber) {

        if (randomNumber <= 4) {
            return true;
        }
        return false;
    }
}
