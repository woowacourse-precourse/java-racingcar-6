package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Race;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaceService {
    private Race race;

    public void initializeRace(String carNames, int rounds) {
        List<Car> cars = parseCarNames(carNames);
        this.race = new Race(cars, rounds);
    }

    public boolean isRaceFinished() {
        return race.isFinished();
    }

    public void runRound() {
        race.runRound();
    }

    public List<Car> getRoundResult() {
        return race.getCars();
    }

    public List<String> getWinners() {
        return race.getWinners();
    }

    private List<Car> parseCarNames(String carNames) {
        return Stream.of(carNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
