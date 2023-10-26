package racingcar.domain.car;

import racingcar.domain.move.Coordinate;

public record Car(
        CarName carName,
        Coordinate coordinate
) {
    public void move() {
        // TODO:
    }
}
