package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String name;
    private int successCount;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    int getSuccessCount() {
        return successCount;
    }

    void tryMoveForward() {
        if(4 <= Randoms.pickNumberInRange(0,9)) {
            successCount++;
        }
    }
}
