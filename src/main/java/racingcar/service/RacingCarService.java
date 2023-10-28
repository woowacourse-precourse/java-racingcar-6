package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.dto.CarProgressResponse;
import racingcar.model.Cars;
import racingcar.model.GameResult;
import racingcar.service.random.RandomNumberProvider;

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

    GameResult determineRaceResult(Cars cars) {
        List<CarProgressResponse> responseList = cars.getCars().stream()
            .map(car ->
                new CarProgressResponse(car.getName(), car.getProgress())
            )
            .toList();

        List<String> winners = cars.getWinner();

        return new GameResult(responseList, winners);
    }
}
