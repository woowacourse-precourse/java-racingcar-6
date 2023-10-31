package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import racingcar.constant.ErrorMessages;
import racingcar.constant.NumberLimits;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<String> carNames) {
        validateRacingCars(carNames);
        this.racingCars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateRacingCars(List<String> carNames) {
        checkForDuplicates(carNames);
        checkCarCountValidity(carNames);
    }

    private void checkCarCountValidity(List<String> carNames) {
        if (carNames.size() < NumberLimits.MIN_RACINGCARS_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.MINIMUM_CAR_COUNT_ERROR);
        }
    }

    private void checkForDuplicates(List<String> carNames) {
        Set<String> set = new HashSet<>(carNames);
        if (set.size() < carNames.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_CAR_NAME_ERROR);
        }
    }

    public int getSize() {
        return racingCars.size();
    }

    public void moveRacingCars(List<Integer> numbers) {
        IntStream.range(0, numbers.size())
                .forEach(index -> racingCars.get(index).moveForward(numbers.get(index)));
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

}
