package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementStrategy implements CarMovementStrategy{

    private final static int MOVEMENT_LIMIT = 4;
    private final static int RANDOM_MAX_LIMIT = 10;

    @Override
    public boolean isMovable() {

        return Randoms.pickNumberInRange(0, RANDOM_MAX_LIMIT) >= MOVEMENT_LIMIT;
    }
}
