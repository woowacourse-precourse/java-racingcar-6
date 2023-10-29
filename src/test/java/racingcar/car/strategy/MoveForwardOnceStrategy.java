package racingcar.car.strategy;

import racingcar.domain.strategy.CarMovementStrategy;

public class MoveForwardOnceStrategy implements CarMovementStrategy {

    @Override
    public int getIncrementValue() {
        return 1;
    }

}
