package racingcar.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public int createBetween0and9() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
