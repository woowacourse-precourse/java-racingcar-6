package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMotionController {

    public static boolean isCarMoved() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}