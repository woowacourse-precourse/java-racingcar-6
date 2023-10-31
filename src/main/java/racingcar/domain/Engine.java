package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {
    private final Integer MIN_FORWARD_NUM = 4;
    public Boolean canMoveForward() {
        return MIN_FORWARD_NUM <= createRandomNumber();
    }

    public Integer createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
