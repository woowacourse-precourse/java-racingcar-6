package racingcar.model;

import java.util.List;
import java.util.stream.IntStream;


public class NCars {
    private final List<Car> cars;

    public NCars(final List<Car> cars) {
        this.cars = cars;
    }

    public static NCars applyNames(final List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::applyName)
                .toList();
        return new NCars(cars);
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
        Integer maxPosition = getWinnerPosition();
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::toString)
                .toList();
    }

    public Integer getWinnerPosition() {
        return cars.stream()
                .map(Car::getRoundResult)
                .mapToInt(RoundResult::position)
                .max()
                .orElse(0);
    }
}