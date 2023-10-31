package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private int successCount;

    int getSuccessCount() {
        return successCount;
    }

    void tryMoveForward() {
        if(4 <= Randoms.pickNumberInRange(0,9)) {
            successCount++;
        }
    }
}
