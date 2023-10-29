package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {

    private boolean isMovingForward() {
        return generateRandomNumber() >= 4;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
