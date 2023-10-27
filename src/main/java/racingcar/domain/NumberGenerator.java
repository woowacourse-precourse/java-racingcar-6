package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int createRandomNumber() {
        int createdNumber = Randoms.pickNumberInRange(0, 9);
        return createdNumber;
    }
}
