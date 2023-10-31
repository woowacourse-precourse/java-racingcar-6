package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int createRandomNumber() {
        int fromNumber = 0;
        int endNumber = 9;

        return Randoms.pickNumberInRange(fromNumber, endNumber);
    }
}
