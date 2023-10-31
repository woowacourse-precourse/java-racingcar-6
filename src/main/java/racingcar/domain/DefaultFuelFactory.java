package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultFuelFactory implements FuelFactory {
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;

    @Override
    public int get() {
        return Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
    }
}
