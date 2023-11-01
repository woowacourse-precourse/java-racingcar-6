package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.position.Position;
import racingcar.domain.power.DefaultPowerGenerator;

public class CarFactoryService {

    private static final int LINEAR_START_POSITION = 0;

    public Cars prepareRacingCars(List<CarName> carNames) {
        List<Car> cars = carNames.stream()
                .map(carName -> new Car(carName, new Position(LINEAR_START_POSITION), new DefaultPowerGenerator()))
                .collect(Collectors.toList());
        return Cars.createFrom(cars);
    }
}
