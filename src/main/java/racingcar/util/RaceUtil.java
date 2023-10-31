package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.constant.ConstNumber;

public final class RaceUtil {

    public static boolean isMove () {
        int randomNum = Randoms.pickNumberInRange(ConstNumber.MIN_RANDOM_NUMBER.getValue(),
                ConstNumber.MAX_RANDOM_NUMBER.getValue());
        return randomNum >= ConstNumber.MOVE_CRITERIA.getValue();
    }
}
