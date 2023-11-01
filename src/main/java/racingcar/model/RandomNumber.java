package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber implements RacingNumber {

    @Override
    public Integer generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
