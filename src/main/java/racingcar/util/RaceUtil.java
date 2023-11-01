package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.constant.ConstNumber;

public final class RaceUtil {

    public static boolean isMove() {
        return isMove(createRandomNumber());
    }

    public static boolean isMove(int randomNum) {
        return randomNum >= ConstNumber.MOVE_CRITERIA.getValue();
    }

    private static int createRandomNumber() {
        return Randoms.pickNumberInRange(ConstNumber.MIN_RANDOM_NUMBER.getValue(),
                ConstNumber.MAX_RANDOM_NUMBER.getValue());
    }
}
