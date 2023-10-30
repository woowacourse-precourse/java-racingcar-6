package domain;

import java.util.List;

public class Race {

    private static final int MIN_CARS_SIZE = 2;

    private static final int MAX_CARS_SIZE = 5;

    private static final String WINNER_DELIMITER = ", ";

    private final List<Car> cars;

    public Race(final List<Car> cars) {
        this.cars = cars;
        validateCans();
    }

    private void validateCans() {
        if (cars.size() < MIN_CARS_SIZE || cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public void moveEachCars() {
        cars.forEach(Car::move);
    }

    public List<String> toStringEachCars() {
        return cars.stream().map(Car::toString).toList();
    }

    public String toWinnerString() {
        final List<Car> winners = findWinner();
        final List<String> winnerNames = winners.stream().map(Car::getName).toList();
        return String.join(WINNER_DELIMITER, winnerNames);
    }

    private List<Car> findWinner() {
        final int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(-1);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).toList();
    }
}
