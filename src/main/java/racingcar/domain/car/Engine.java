package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {
    private final static int MIN_VALUE = 0;
    private final static int MAX_VALUE = 9;

    private Engine() {
    }

    public static Engine newInstance() {
        return new Engine();
    }

    public int pressAccelerator() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

}
