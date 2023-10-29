package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRacing {
    private boolean isCarMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
