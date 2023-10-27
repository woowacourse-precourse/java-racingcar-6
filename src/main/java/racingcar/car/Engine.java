package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {
    private final static int MAX_RANDOM_VALUE = 9;
    private final static int MIN_RANDOM_VALUE = 0;
    private final static int FORWARD_DISTANCE_VALUE = 3;

    public boolean isForward() {
        return Randoms.pickNumberInRange(MAX_RANDOM_VALUE, MIN_RANDOM_VALUE) > FORWARD_DISTANCE_VALUE ;
    }

}
