package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int createRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}
