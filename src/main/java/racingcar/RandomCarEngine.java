package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCarEngine implements CarEngine {
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int MIN_START_ENGINE_NUMBER = 4;

    @Override
    public boolean isStart() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MIN_START_ENGINE_NUMBER;
    }
}
