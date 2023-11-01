package racingcar.domain.car.strategy;

public class MoveForwardOnceStrategy implements CarMovementStrategy {

    @Override
    public int getIncrementValue() {
        return 1;
    }

}
