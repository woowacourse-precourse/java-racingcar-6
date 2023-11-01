package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Moving {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private static final int MOVABLE_MIN_NUMBER = 4;

    public static boolean isMovable() {
        int randomNumber = pickNumberInRange(MIN_RANGE, MAX_RANGE);
        if (randomNumber >= MOVABLE_MIN_NUMBER) {
            return true;
        }
        return false;
    }

}
