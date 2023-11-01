package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatus;
import racingcar.model.Cars;

public class GameService {

    public void tryRunCars(Cars cars) {
        cars.tryRun();
    }

    public List<CarStatus> getCarStatusOfRace(Cars cars) {
        return cars.getCars()
                .stream()
                .map(CarStatus::new)
                .collect(Collectors.toList());
    }
}