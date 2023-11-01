package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class RacingCars {
    private static final int MIN_RACINGCARS_SIZE = 2;
    private static final String DUPLICATE_CAR_NAME_ERROR = "[ERROR] : 중복되지 않은 자동차 이름을 입력해주세요.";
    private static final String MINIMUM_CAR_COUNT_ERROR = "[ERROR] : 두 개 이상의 자동차를 입력해주세요";
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
        if (carNames.size() < MIN_RACINGCARS_SIZE) {
            throw new IllegalArgumentException(MINIMUM_CAR_COUNT_ERROR);
        }
    }

    private void checkForDuplicates(List<String> carNames) {
        Set<String> set = new HashSet<>(carNames);
        if (set.size() < carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR);
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
