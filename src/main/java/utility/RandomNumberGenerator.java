package utility;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private final int GENERATING_FOR_CAR_TRY_MOVING_RANGE_START_NUMBER = 0;
    private final int GENERATING_FOR_CAR_TRY_MOVING_RANGE_END_NUMBER = 9;

    public int generatingForCarTryMoving() {
        return Randoms.pickNumberInRange(GENERATING_FOR_CAR_TRY_MOVING_RANGE_START_NUMBER, GENERATING_FOR_CAR_TRY_MOVING_RANGE_END_NUMBER);
    }
}
