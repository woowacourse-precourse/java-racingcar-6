package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.Size;

public class Moving {

    public boolean decide(int min, int max) {
        return Randoms.pickNumberInRange(min, max) >= Size.MOVING_BOUNDARY.getValue();
    }

    public boolean decide() {
        return decide(Size.ROLL_MIN.getValue(), Size.ROLL_MAX.getValue());
    }

}
