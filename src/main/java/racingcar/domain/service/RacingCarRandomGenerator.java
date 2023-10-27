package racingcar.domain.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarRandomGenerator implements RandomGenerator{
    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(1,9);
    }
}
