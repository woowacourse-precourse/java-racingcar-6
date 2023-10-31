package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    public int makeNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
