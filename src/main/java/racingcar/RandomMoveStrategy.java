package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;
    private static final int MOVABLE_THRESHOLD = 4;

    @Override
    public boolean determineMovable() {
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND) >= MOVABLE_THRESHOLD;
    }
}
