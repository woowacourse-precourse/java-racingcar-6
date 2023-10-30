package racingcar.service;

import racingcar.dto.CarStatus;
import racingcar.dto.RaceResult;
import racingcar.model.Car;
import racingcar.model.CarFactory;

import java.util.ArrayList;
import java.util.Collections;
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
        List<CarStatus> carStatuses = move(cars);
        return new RaceResult(roundCount, carStatuses);
    }

    private List<CarStatus> move(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    car.forward();
                    return car.getStatus();
                })
                .toList();
    }

    public List<String> getWinners() {
        int maximumDistance = getMaximumDistance();
        return cars.stream()
                .filter(car -> car.isWinner(maximumDistance))
                .map(car -> car.getStatus().carName())
                .toList();
    }

    private int getMaximumDistance() {
        List<Integer> carPositions = cars.stream()
                .map(car -> car.getStatus().position())
                .toList();
        return Collections.max(carPositions);
    }
}
