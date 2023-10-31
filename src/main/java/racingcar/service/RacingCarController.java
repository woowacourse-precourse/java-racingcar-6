package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarController {
    public static boolean isMoveForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
