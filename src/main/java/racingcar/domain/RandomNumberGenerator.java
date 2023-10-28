package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public static int generateNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}