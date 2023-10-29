package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static boolean randomNumber() {
        int randomNumber = Randoms.pickNumberInRange(1,9);

        if (randomNumber < 4) {
            return true;
        }
        return false;
    }
}
