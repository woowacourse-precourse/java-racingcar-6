package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public Integer generateInRange(Integer min, Integer max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
