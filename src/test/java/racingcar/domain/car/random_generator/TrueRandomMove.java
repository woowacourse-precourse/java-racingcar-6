package racingcar.domain.car.random_generator;

import racingcar.domain.car.RandomUtil;

public class TrueRandomMove implements RandomUtil {
    @Override
    public boolean moveForward() {
        return true;
    }
}
