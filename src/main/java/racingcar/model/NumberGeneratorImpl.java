package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGeneratorImpl implements NumberGenerator {

    @Override
    public Integer generateInRange(Integer min, Integer max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
