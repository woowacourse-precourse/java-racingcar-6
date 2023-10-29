package racingcar.Util;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMovement {
    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;
    private static final int FORWARD_MIN_NUMBER = 4;

    public static boolean movingStatus(){
        if (Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END) >= FORWARD_MIN_NUMBER){
            return true;
        }
        return false;
    }
}
