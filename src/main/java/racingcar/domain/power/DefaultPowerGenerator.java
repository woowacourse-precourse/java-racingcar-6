package racingcar.domain.power;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultPowerGenerator implements PowerGenerator {

    private static final int MIN_POWER = 0;
    private static final int MAX_POWER = 9;

    @Override
    public Power generate() {
        return new Power(Randoms.pickNumberInRange(MIN_POWER, MAX_POWER));
    }

}
