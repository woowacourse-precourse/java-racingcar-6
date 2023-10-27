package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMaker {
    private RandomMaker() {

    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
