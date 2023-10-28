package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public int makeRandomNum() {
        return Randoms.pickNumberInRange(0,9);
    }
}
