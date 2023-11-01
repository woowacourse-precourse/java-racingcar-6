package model;

import camp.nextstep.edu.missionutils.Randoms;
import constants.Constants;

public class AdvanceDecider {

    public boolean isPossibleToAdvance() {
        return isPossibleToAdvanceWhenValueIs(getRandomInt());
    }

    private int getRandomInt() {
        return Randoms.pickNumberInRange(Constants.MIN_RANDOM_VALUE, Constants.MAX_RANDOM_VALUE);
    }

    private boolean isPossibleToAdvanceWhenValueIs(int randomValue) {
        return randomValue >= Constants.MIN_VALUE_TO_ADVANCE;
    }
}