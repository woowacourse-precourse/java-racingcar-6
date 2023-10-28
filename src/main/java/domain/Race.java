package domain;

import java.util.List;

public class Race {

    private static final String WINNER_DELIMITER = ", ";

    private final List<Car> cars;

    public Race(final List<Car> cars) {
        this.cars = cars;
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
