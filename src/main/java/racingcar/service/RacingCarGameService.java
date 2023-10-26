package racingcar.service;

import racingcar.domain.car.Car;
import racingcar.domain.race.RaceChecker;
import racingcar.domain.race.RaceResult;

import java.util.List;

public class RacingCarGameService {
    private final RaceChecker raceChecker;

    public RacingCarGameService(RaceChecker raceChecker) {
        this.raceChecker = raceChecker;
    }

    public void play(List<Car> cars) {
        cars.forEach(Car::move);
    }

    public RaceResult checkWinner(List<Car> cars) {
        return raceChecker.checkWinner(cars);
    }
}
