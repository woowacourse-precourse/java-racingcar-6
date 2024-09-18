package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveForward {
    //어떻게 할 것인가, 상황별 로직

    private final int trialCount;

    public MoveForward(int trialCount) {
        this.trialCount = trialCount;
    }

    public int getTrialCount() {
        return trialCount;
    }

    public static int randomMoveForwards() {
        return Randoms.pickNumberInRange(0,9);
    }


}
