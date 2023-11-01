package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Constant;

public class Forward implements CarMovement {

    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(Constant.START_INCLUSIVE,
                Constant.END_INCLUSIVE);
    }

    @Override
    public boolean isSuccessForward() {
        return Constant.FORWARD_CONDITION <= generateRandomNumber();
    }
}
