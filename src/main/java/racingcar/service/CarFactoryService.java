package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.position.Position;
import racingcar.domain.power.DefaultPowerGenerator;

public class CarFactoryService {

    public Cars prepareRacingCars(List<CarName> carNames) {
        List<Car> cars = carNames.stream()
                .map(carName -> new Car(carName, new Position(0), new DefaultPowerGenerator()))
                .collect(Collectors.toList());
        return Cars.createFrom(cars);
    }
}
