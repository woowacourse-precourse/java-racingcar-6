package racingcar.model;

import racingcar.service.MovementStrategy;

public record Car(String carName, int distance, MovementStrategy movementStrategy) {
    public Car attemptMove() {
        if (movementStrategy.canMove()) {
            return new Car(carName, distance + 1, movementStrategy);
        }
        return new Car(carName, distance, movementStrategy);
    }
}
