package racingcar.model.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCarMoveRule implements CarMoveRule {

    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int THRESHOLD = 4;

    @Override
    public boolean isGo() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) >= THRESHOLD;
    }
}
