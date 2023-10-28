package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingNumberGenerator implements RandomNumberGenerator{

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
