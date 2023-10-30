package racingcar.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.constants.ExceptionMessages;
import racingcar.util.NumberGenerator;

public record Cars(List<Car> cars) {
    private static final int CARS_COUNT_MIN = 2;

    public Cars {
        validateCars(cars);
    }

    private void validateCars(final List<Car> cars) {
        validateDuplicateName(cars);
        validateMinimumCarCount(cars);
    }

    private void validateDuplicateName(final List<Car> cars) {
        if (hasDuplicateName(cars)) {
            ExceptionMessages.NOT_INPUT_CARS_DUPLICATE.throwException();
        }
    }

    private void validateMinimumCarCount(final List<Car> cars) {
        if (hasMinimumCarCount(cars)) {
            ExceptionMessages.CARS_LESS_THAN_TWO.throwException();
        }
    }

    private boolean hasDuplicateName(final List<Car> cars) {
        Set<String> carNames = new HashSet<>();
        return cars.stream()
                .map(Car::getName)
                .anyMatch(name -> !carNames.add(name));
    }

    private boolean hasMinimumCarCount(final List<Car> cars) {
        return cars.size() < CARS_COUNT_MIN;
    }

    public void moveAll(NumberGenerator numberGenerator) {
        for (final Car car : cars) {
            final int value = numberGenerator.generateRandomNumber();
            car.moveToCar(value);
        }
    }

    @Override
    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public Map<String, Integer> getRacingStatus() {
        Map<String, Integer> racingStatus = new HashMap<>();

        for (Car car : cars()) {
            racingStatus.put(car.getName(), car.getPosition());
        }

        return racingStatus;
    }

    public List<String> getTopRacers() {
        Map<String, Integer> racingStatus = getRacingStatus();
        int topPosition = getTopPosition(racingStatus);
        return getTopRacerNames(racingStatus, topPosition);
    }

    private int getTopPosition(Map<String, Integer> racingStatus) {
        int topPosition = Integer.MIN_VALUE;
        for (int position : racingStatus.values()) {
            topPosition = Math.max(position, topPosition);
        }
        return topPosition;
    }

    private List<String> getTopRacerNames(Map<String, Integer> racingStatus, int topPosition) {
        return racingStatus.entrySet().stream()
                .filter(entry -> entry.getValue() == topPosition)
                .map(Map.Entry::getKey)
                .toList();
    }
}
