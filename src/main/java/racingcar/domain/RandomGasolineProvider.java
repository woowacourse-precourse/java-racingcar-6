package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGasolineProvider implements GasolineProvider {

    private static final int MIN_GASOLINE = 0;
    private static final int MAX_GASOLINE = 9;

    public int provide() {
        return Randoms.pickNumberInRange(MIN_GASOLINE, MAX_GASOLINE);
    }
}
