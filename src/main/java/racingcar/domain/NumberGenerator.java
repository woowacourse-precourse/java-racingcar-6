package racingcar.domain;

import static racingcar.constant.RaceSetting.*;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public int generator() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER.getValue(), MAX_RANDOM_NUMBER.getValue());
    }
}
