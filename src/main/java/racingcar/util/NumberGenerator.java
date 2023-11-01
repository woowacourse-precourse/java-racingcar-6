package racingcar.util;

import static racingcar.constant.NumberConstant.MAX_NUMBER_RANGE;
import static racingcar.constant.NumberConstant.MIN_NUMBER_RANGE;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE.getNumber(), MAX_NUMBER_RANGE.getNumber());
    }
}
