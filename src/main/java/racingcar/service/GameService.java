package racingcar.service;

import racingcar.dto.CarStatus;
import racingcar.dto.RaceResult;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.repository.CarRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameService {

    private final CarRepository carRepository;

    public GameService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void initCars(List<String> carNames) {
        carRepository.saveAll(CarFactory.initCars(carNames));
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
        List<CarStatus> carStatuses = movingCars();
        return new RaceResult(roundCount, carStatuses);
    }

    private List<CarStatus> movingCars() {
        List<Car> cars = carRepository.getAll();
        return cars.stream()
                .map(car -> {
                    car.forward();
                    return car.getStatus();
                })
                .toList();
    }

    public List<String> getWinners() {
        List<Car> cars = carRepository.getAll();
        int maximumDistance = getMaximumDistance();

        return cars.stream()
                .filter(car -> car.isWinner(maximumDistance))
                .map(car -> car.getStatus().carName())
                .toList();
    }

    private int getMaximumDistance() {
        List<Car> cars = carRepository.getAll();
        List<Integer> carPositions = cars.stream()
                .map(car -> car.getStatus().position())
                .toList();

        return Collections.max(carPositions);
    }
}
