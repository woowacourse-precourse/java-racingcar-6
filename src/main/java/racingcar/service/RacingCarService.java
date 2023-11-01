package racingcar.service;

import java.util.Arrays;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.round.RoundResult;

public class RacingCarService {

    private static final Cars cars = new Cars();
    private RoundResult roundResults;

    public void createCars(String[] drivers) {
        cars.createCars(drivers);
    }

    public void updateRacingResult() {
        cars.moveCars();
    }

    public String getRoundResults() {
        roundResults = new RoundResult(cars.getCars());
        return roundResults.getRoundResult();
    }

    public String getChampionResult() {
        return Arrays.stream(cars.getCars())
            .filter(car -> car.getMileage() == roundResults.getMaxMoveCount())
            .map(Car::getName)
            .collect(Collectors.joining(" "));
    }
}