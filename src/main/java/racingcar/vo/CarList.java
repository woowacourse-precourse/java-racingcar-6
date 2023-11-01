package racingcar.vo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class CarList {
    private static final String STRING_WINNER_DELIMITER = ", ";
    private final List<Car> carList;

    public CarList(final List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public void moveForward() {
        carList.stream()
                .forEach(Car::moveForward);
    }

    public List<Car> getCarListWithLongestDistance() {
        final int longestDistance = getLongestDistanceFromCarList();
        final List<Car> carListWithLongestDistance = filterCarListWithLongestDistance(longestDistance);
        return Collections.unmodifiableList(carListWithLongestDistance);
    }

    private int getLongestDistanceFromCarList() {
        final int longestDistance = carList.stream().mapToInt(Car::getDistance).max().orElse(0);
        return longestDistance;
    }

    private List<Car> filterCarListWithLongestDistance(final int longestDistance) {
        return carList.stream()
                .filter(car -> car.getDistance() == longestDistance)
                .collect(Collectors.toUnmodifiableList());
    }

    public String getWinners() {
        final List<Car> carListWithLongestDistance = getCarListWithLongestDistance();
        final List<String> winnerList = carListWithLongestDistance.stream()
                .map(Car::getName).collect(Collectors.toUnmodifiableList());
        final String winners = String.join(STRING_WINNER_DELIMITER, winnerList);
        return winners;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (getClass() != other.getClass()) {
            return false;
        }

        final CarList otherCarList = (CarList) other;
        return carList.equals(otherCarList.carList);
    }
}
