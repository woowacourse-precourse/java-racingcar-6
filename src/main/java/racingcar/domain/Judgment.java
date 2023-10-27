package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Judgment {

    private static final int FIRST_VALUE=0;
    private static final int LAST_VALUE=0;
    private static final int FORWARD_CONDITION=4;

    public boolean isNumberFourOrMore() {
        return createRandomNumber()>=FORWARD_CONDITION;
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(FIRST_VALUE,LAST_VALUE);
    }
}
