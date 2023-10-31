package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker {
    private RandomNumberMaker() {
    }
    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
