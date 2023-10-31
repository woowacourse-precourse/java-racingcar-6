package racingcar.dto;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.position.Position;

public class CarStatusDto {
    private final CarName carName;
    private final Position carPosition;

    private CarStatusDto(CarName carName, Position carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static CarStatusDto createFrom(Car car) {
        CarName clonedCarName = new CarName(car.getCarName().getValue());
        Position clonedPosition = new Position(car.getPosition().getValue());
        return new CarStatusDto(clonedCarName, clonedPosition);
    }

    public CarName getCarName() {
        return carName;
    }

    public Position getCarPosition() {
        return carPosition;
    }
}
