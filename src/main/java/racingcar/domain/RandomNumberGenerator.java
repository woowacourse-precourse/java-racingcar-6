package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int createRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return randomNumber;
    }

    public int createRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}
