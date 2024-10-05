package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker {

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
