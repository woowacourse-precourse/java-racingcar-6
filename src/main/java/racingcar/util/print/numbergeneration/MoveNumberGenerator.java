package racingcar.util.print.numbergeneration;

import static racingcar.util.print.constants.RacingGameConstants.FROM_MIN_VALUE;
import static racingcar.util.print.constants.RacingGameConstants.TO_MAX_VALUE;

import camp.nextstep.edu.missionutils.Randoms;

public abstract class MoveNumberGenerator {
    private MoveNumberGenerator() {
    }

    public static int generateNumber() {
        return Randoms.pickNumberInRange(FROM_MIN_VALUE,TO_MAX_VALUE);
    }
}
