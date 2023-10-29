package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MovingCondition {
    public boolean isMoveForward() {
        int condition = Randoms.pickNumberInRange(0,9);

        if (condition > 3)
            return true;

        return false;
    }
}
