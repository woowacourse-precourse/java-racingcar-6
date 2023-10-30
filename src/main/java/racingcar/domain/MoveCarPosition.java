package racingcar.domain;

import racingcar.domain.entity.CarEntity;

public class MoveCarPosition {
    public static void move(CarEntity car) {
        car.movePosition();
    }
}
