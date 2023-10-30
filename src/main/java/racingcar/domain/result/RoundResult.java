package racingcar.domain.result;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.movement.MovementHistory;

public class RoundResult {
    private final List<Car> cars;
    private final List<MovementHistory> MovementHistories;

    public RoundResult(List<Car> cars, List<MovementHistory> movementHistories) {
        this.cars = cars;
        MovementHistories = movementHistories;
    }

    public List<MovementHistory> getMovementHistories() {
        return MovementHistories;
    }
    public List<Car> getCars() {
        return cars;
    }
}
