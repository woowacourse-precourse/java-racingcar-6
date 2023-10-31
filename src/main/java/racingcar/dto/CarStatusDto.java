package racingcar.dto;

import racingcar.domain.car.CarName;
import racingcar.domain.position.Position;

public class CarStatusDto {
    private final CarName carName;
    private final Position carPosition;

    public CarStatusDto(CarName carName, Position carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public CarName getCarName() {
        return carName;
    }

    public Position getCarPosition() {
        return carPosition;
    }
}
