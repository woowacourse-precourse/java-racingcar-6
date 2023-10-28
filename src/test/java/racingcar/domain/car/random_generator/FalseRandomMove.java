package racingcar.domain.car.random_generator;

import racingcar.domain.car.RandomUtil;

public class FalseRandomMove implements RandomUtil {
    @Override
    public boolean moveForward() {
        return false;
    }
}
