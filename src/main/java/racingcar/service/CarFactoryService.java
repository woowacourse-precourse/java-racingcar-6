package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.position.Position;
import racingcar.domain.power.DefaultPowerGenerator;

public class CarFactoryService {

    public List<Car> prepareRacingCars(List<CarName> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, new Position(0), new DefaultPowerGenerator()))
                .collect(Collectors.toList());
    }
}
