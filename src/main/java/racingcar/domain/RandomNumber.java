package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    public int createRandom() {
        int number = Randoms.pickNumberInRange(1, 9);
        return number;
    }
}
