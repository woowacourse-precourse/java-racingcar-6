package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public int createNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
