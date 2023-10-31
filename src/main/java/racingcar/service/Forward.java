package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Constant;

class Forward implements CarMovement {
    @Override
    public boolean isSuccessForward() {
        return Constant.FORWARD_CONDITION <= Randoms.pickNumberInRange(Constant.START_INCLUSIVE,
                Constant.END_INCLUSIVE);
    }
}
