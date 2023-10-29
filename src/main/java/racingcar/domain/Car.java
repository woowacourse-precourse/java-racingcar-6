package racingcar.domain;

import java.util.Objects;
import racingcar.dto.CarInformationDto;

public class Car {

    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition();
    }

    public CarInformationDto getInformation() {
        String carName = name.name();
        int carPosition = position.getPosition();
        return new CarInformationDto(carName, carPosition);
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

}
