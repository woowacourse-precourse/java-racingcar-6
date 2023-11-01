package racingcar.service;

import java.util.LinkedHashSet;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarDto;

public class RacingService {
    private final RaceResultGenerator raceResultGenerator;

    public RacingService(RaceResultGenerator raceResultGenerator) {
        this.raceResultGenerator = raceResultGenerator;
    }

    public void moveAllCar(int attemptCount, LinkedHashSet<Car> cars, Runnable afterEachRound) {
        for (int i = 0; i < attemptCount; i++) {
            moveCar(cars);
            afterEachRound.run();
        }
    }

    private void moveCar (LinkedHashSet <Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> generateRaceResult(LinkedHashSet<CarDto> carDtos) {
        return raceResultGenerator.checkWinner(carDtos);
    }
}

