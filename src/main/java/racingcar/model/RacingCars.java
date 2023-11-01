package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public non-sealed class RacingCars implements Cars{
    private final List<Car> cars;

    public RacingCars(final List<Car> cars) {
        this.cars = cars;
    }
    public RacingCars() {
        this.cars = new ArrayList<>();
    }
    public RacingCars applyNames(final List<String> names) {
        int numberOfPeople = names.size();
        IntStream.range(0,numberOfPeople).forEach(i->{
            cars.add(Car.applyName(names.get(i)));
        });
        return this;
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
