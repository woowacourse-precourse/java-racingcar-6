package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    static public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
