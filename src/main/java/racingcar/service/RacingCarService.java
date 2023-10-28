package racingcar.service;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.GameResult;

public final class RacingCarService {
    public GameResult race(List<String> inputCarNames, int raceTime) {
        Cars cars = prepareCars(inputCarNames);
        GameResult gameResult = determineRaceResult(startRace(cars, raceTime));
        return gameResult;

    }

    private Cars prepareCars(List<String> inputCarNames) {
        List<Car> carList = inputCarNames.stream()
            .map(Car::from)
            .toList();

        return Cars.from(carList);
    }

    private Cars startRace(Cars cars, int raceTime) {
        return null;
    }

    private GameResult determineRaceResult(Cars cars) {
        return null;
    }
}
