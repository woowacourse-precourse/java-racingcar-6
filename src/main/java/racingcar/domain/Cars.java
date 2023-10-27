package racingcar.domain;

import java.util.Collections;
import java.util.List;

public record Cars(List<Car> cars) {

    private static final int START_POSITION = 0;
    private static final int MIN_ADDITION_NUMBER = 2;

    public static Cars from(final List<String> carNames) {
        CarsValidator.validate(carNames);
        return new Cars(carNames.stream()
                .map(name -> Car.of(name, START_POSITION))
                .toList());
    }

    public void moveForwardWithAllCars(final int randomNumber) {
        for (Car car : cars) {
            car.moveForward(randomNumber);
        }
    }

    @Override
    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    private static class CarsValidator {

        private static void validate(final List<String> carNames) {
            validateDuplicate(carNames);
            validateCarCount(carNames);
        }

        private static void validateDuplicate(final List<String> carNames) {
            if (isDuplicates(carNames)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }

        private static void validateCarCount(final List<String> carNames) {
            if (carNames.size() < MIN_ADDITION_NUMBER) {
                throw new IllegalArgumentException("자동차는 2대 이상 등록해야 합니다");
            }
        }

        private static boolean isDuplicates(final List<String> carNames) {
            return carNames.size() != carNames.stream().distinct().count();
        }
    }
}
