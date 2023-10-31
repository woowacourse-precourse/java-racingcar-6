package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {
    public Boolean canMoveForward() {
        return true;
    }

    public Integer createRandomnumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
