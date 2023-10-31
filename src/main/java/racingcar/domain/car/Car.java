package racingcar.domain.car;

import java.util.Objects;
import racingcar.domain.car.strategy.CarMovementStrategy;
import racingcar.dto.CarInformationDto;

public class Car {

    private final CarName name;
    private final CarPosition position;
    private final CarMovementStrategy carMovementStrategy;

    public Car(String name, CarMovementStrategy carMovementStrategy) {
        this.name = new CarName(name);
        this.position = new CarPosition();
        this.carMovementStrategy = carMovementStrategy;
    }

    public CarInformationDto getInformation() {
        String carName = name.name();
        int carPosition = position.getPosition();
        return new CarInformationDto(carName, carPosition);
    }

    public void move() {
        int incrementValue = carMovementStrategy.getIncrementValue();
        position.move(incrementValue);
    }

    @Override
    public boolean equals(Object obj) {
        Car car = (Car) obj;
        CarName carName = car.name;
        CarPosition carPosition = car.position;
        boolean isNameEquals = name.equals(carName);
        boolean isPositionEquals = position.equals(carPosition);
        return isNameEquals && isPositionEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public String getName() {
        return name.name();
    }

    public int getPosition() {
        return position.getPosition();
    }

}
