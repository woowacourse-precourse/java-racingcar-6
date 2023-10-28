package racingcar.service;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.GameResult;

public final class RacingCarService {

    private final RandomNumberProvider randomNumberProvider;

    public RacingCarService(RandomNumberProvider randomNumberProvider) {
        this.randomNumberProvider = randomNumberProvider;
    }

    public GameResult race(List<String> inputCarNames, int raceTime) {
        Cars cars = prepareCars(inputCarNames);
        GameResult gameResult = determineRaceResult(startRace(cars, raceTime));
        return gameResult;

    }

    Cars prepareCars(List<String> inputCarNames) {
        List<Car> carList = inputCarNames.stream()
            .map(Car::from)
            .toList();

        return Cars.from(carList);
    }

    Cars startRace(Cars cars, int raceTime) {
        for (int i = 0; i < raceTime; i++) {
            List<Car> movedCars = cars.getCars().stream()
                .map(car -> car.move(randomNumberProvider.getRandomNumber()))
                .collect(Collectors.toList());
            cars = Cars.from(movedCars);
        }

        return cars;
    }

    private GameResult determineRaceResult(Cars cars) {
        return null;
    }
}
