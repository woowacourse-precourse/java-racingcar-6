package model;

import camp.nextstep.edu.missionutils.Randoms;

public class CompareNumberReferee implements Referee {

    private static final int CONDITION_NUMBER = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    @Override
    public boolean isSatisfiedCondition() {
        int pickedNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return pickedNumber >= CONDITION_NUMBER;
    }
}
