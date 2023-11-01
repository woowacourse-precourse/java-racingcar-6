package racingcar.model.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.rule.CarMovementStatus;
import racingcar.model.result.RaceResult;
import racingcar.model.rule.RandomNumberGenerator;
import racingcar.model.result.RoundResult;

public non-sealed class RacingCars implements Cars {
    private final List<Car> cars;
    public RacingCars(final List<Car> cars) {
        this.cars = List.copyOf(cars);
    }
    public RacingCars() {
        this.cars = new ArrayList<>();
    }
    public RacingCars applyNames(final List<String> names) {
        List<Car> newCars = new ArrayList<>(this.cars);
        for (String name : names) {
            Name carName = new Name(name);
            newCars.add(Car.applyName(carName));
        }
        return new RacingCars(newCars);
    }

    public List<Integer> moveCars() {
        return this.cars.stream()
                .map(car -> car.changePosition(
                        CarMovementStatus.getMovementStatusByCheckNumber(
                                RandomNumberGenerator.getRandomNUmber())))
                .toList();
    }

    public List<List<Integer>> moveCarsRepeatedByRound(Integer round) {
        return IntStream.range(0, round)
                .mapToObj(i -> moveCars())
                .toList();
    }

    public List<String> getSingleRoundResult() {
        return cars.stream()
                .map(car -> car.getRoundResult().toString())
                .toList();
    }

    public List<String> getNamesForTest() {
        return this.cars.stream()
                .map(Car::toString)
                .toList();
    }

    public List<String> getWinnerName() {
        RaceResult raceResult = getRaceResult();
        return raceResult.getWinnerNames();
    }

    private RaceResult getRaceResult() {
        List<RoundResult> results = cars.stream()
                .map(Car::getRoundResult).toList();
        return new RaceResult(results);
    }
}
