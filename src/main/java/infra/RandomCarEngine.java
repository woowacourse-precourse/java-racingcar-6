package infra;

import camp.nextstep.edu.missionutils.Randoms;
import domain.CarEngine;

public class RandomCarEngine implements CarEngine {

    private static final int MOVE_FORWARD_THRESHOLD = 4;

    private static final int MIN_RANDOM_INT = 0;

    private static final int MAX_RANDOM_INT = 9;

    @Override
    public boolean canMoveForward() {
        final int random = Randoms.pickNumberInRange(MIN_RANDOM_INT, MAX_RANDOM_INT);
        return random >= MOVE_FORWARD_THRESHOLD;
    }
}
