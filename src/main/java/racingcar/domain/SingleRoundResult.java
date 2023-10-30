package racingcar.domain;

import java.util.List;

public class SingleRoundResult {
    private final List<Car> cars;
    private final List<MovementHistory> MovementHistories;

    public SingleRoundResult(List<Car> cars, List<MovementHistory> movementHistories) {
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
