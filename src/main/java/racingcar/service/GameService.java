package racingcar.service;

import racingcar.dto.CarStatus;
import racingcar.dto.RaceResult;
import racingcar.model.Car;
import racingcar.model.CarFactory;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private final List<Car> cars = new ArrayList<>();

    public void initCars(List<String> carNames) {
        cars.addAll(CarFactory.initCars(carNames));
    }

    public List<RaceResult> race(int raceCount) {
        List<RaceResult> result = new ArrayList<>();

        for (int roundCount = 1; roundCount <= raceCount; roundCount++) {
            RaceResult raceResult = play(roundCount);
            result.add(raceResult);
        }

        return result;
    }

    private RaceResult play(int roundCount) {
        List<CarStatus> carStatuses = play(cars);
        return new RaceResult(roundCount, carStatuses);
    }

    private List<CarStatus> play(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    car.forward();
                    return car.getStatus();
                })
                .toList();
    }
}
