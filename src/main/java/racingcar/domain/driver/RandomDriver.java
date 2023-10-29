package racingcar.domain.driver;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDriver implements Driver{
    private static final int RANDOM_UPPER_BOUND = 9;
    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int MOVE_BOUND = 4;
    @Override
    public boolean drive() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND) >= MOVE_BOUND;
    }
}
