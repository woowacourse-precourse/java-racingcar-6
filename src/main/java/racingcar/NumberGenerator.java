package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public static Integer createRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
