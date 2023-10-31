package racingcar.model.car;

import racingcar.utils.random.RandomUtils;

public class Movable {

    private static final int MOVABLE_VALUE = 4;

    public Movable() {
    }

    public boolean isMove() {
        return RandomUtils.pick() >= MOVABLE_VALUE;
    }
}
