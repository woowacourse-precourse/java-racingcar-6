package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarEngine;
import racingcar.domain.Cars;

public class RacingCarAssemblyService {

    public Cars assemble(List<String> inputCarNames, CarEngine carEngine) {
        List<Car> carList = inputCarNames.stream()
                .map(carName -> new Car(carName, carEngine))
                .collect(Collectors.toList());
        return new Cars(carList);
    }
}
