package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Forward implements CarMovement {
    private final int  random = Randoms.pickNumberInRange(0,Global.FORWARD_MAX - 1);

    @Override
    public boolean isSuccess() {
        return Global.FORWARD_MIN <= random;
    }
}
