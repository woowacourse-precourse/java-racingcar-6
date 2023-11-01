package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static int generateNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
