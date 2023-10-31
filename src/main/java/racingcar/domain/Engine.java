package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {
    private final Integer MIN_FORWARD_NUM = 4;
    public Boolean canMoveForward(Integer randomNumber) {
        return 4 <= randomNumber;
    }

    public Integer createRandomnumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
