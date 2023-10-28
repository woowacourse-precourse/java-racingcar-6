package model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomReferee implements Referee {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int CONDITION_NUMBER = 4;

    @Override
    public boolean isSatisfiedCondition() {
        int randomNum = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return randomNum >= CONDITION_NUMBER;
    }
}
