package racingcar.util;

import static racingcar.util.Constant.END_INCLUSIVE;
import static racingcar.util.Constant.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue());
    }
}
