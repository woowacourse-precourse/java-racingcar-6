package racingcar.model.car;

import racingcar.utils.random.RandomUtils;

public class RandomMovable implements Movable{

    private static final int MOVABLE_VALUE = 4;

    public RandomMovable() {
    }

    public boolean isMove() {
        return RandomUtils.pick() >= MOVABLE_VALUE;
    }
}
