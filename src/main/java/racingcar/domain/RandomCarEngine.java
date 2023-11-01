package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCarEngine implements CarEngine {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_START_ENGINE_NUMBER = 4;

    @Override
    public boolean isStart() {
        return MIN_START_ENGINE_NUMBER <= Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
