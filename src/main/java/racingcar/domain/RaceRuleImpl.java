package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceRuleImpl implements RaceRule {

    private static final int MOVABLE_NUMBER = 4;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    public boolean isMove() {
        int generateNum = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);

        if(generateNum >= MOVABLE_NUMBER) {
            return true;
        }

        return false;
    }

}
