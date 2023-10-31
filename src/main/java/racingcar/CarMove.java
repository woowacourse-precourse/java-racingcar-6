package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMove {
    public static boolean decideCarMovement() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
