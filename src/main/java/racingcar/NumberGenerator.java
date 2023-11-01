package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int createRandomNumber() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number;
    }
}
