package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {
    private final Integer MIN_FORWARD_NUM = 4;
    private final Integer MIN_RANDOM_NUM = 0;
    private final Integer MAX_RANDOM_NUM = 9;

    public Boolean canMoveForward() {
        return MIN_FORWARD_NUM <= createRandomNumber();
    }

    public Integer createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }
}
