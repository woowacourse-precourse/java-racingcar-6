package racingcar.domain;

import java.util.List;

public class CarRaceJudge {

    public static final int START_POSITION = 0;

    private final CarRepository carRepository = CarRepository.getInstance();

    public void addCars(final List<String> carNames) {
        validateDuplicates(carNames);
        List<Car> cars = carNames.stream()
                .map(name -> Car.of(name, START_POSITION))
                .toList();

        carRepository.saveAll(cars);
    }

    private void validateDuplicates(final List<String> carNames) {
        if (isDuplicates(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private boolean isDuplicates(final List<String> carNames) {
        return carNames.size() != carNames.stream().distinct().count();
    }
}
