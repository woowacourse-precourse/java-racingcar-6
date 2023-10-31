package racingcar.service.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.configuration.ConfigurationConstants;

// TODO: for문 람다식으로 수정
// TODO: RacingCars가 검증해야할 부분 방어 코드 작성 [V]
// TODO: RacingCars public 메서드 단위 테스트
// TODO: getter 없애도록 고민해볼 것
public class RacingCars {
    private static final String DUPLICATE_EXISTS = "중복된 이름이 존재합니다.";
    private static final String OUT_OF_CAPACITY = "자동차 개수 범위가 맞지 않습니다.";
    private final List<Car> cars;

    public RacingCars(List<String> carNames, CarEngine carEngine) {
        List<Car> cars = mapToCarList(carNames, carEngine);
        validateDuplicate(cars, carNames);
        validateTotalCount(cars);
        this.cars = cars;
    }

    private List<Car> mapToCarList(List<String> carNames, CarEngine carEngine) {
        return carNames.stream()
                .map(carName -> new Car(carName, carEngine))
                .distinct()
                .collect(Collectors.toList());
    }

    private void validateDuplicate(List<Car> cars, List<String> carNames) {
        if (cars.size() != carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXISTS);
        }
    }

    private void validateTotalCount(List<Car> cars) {
        if (cars.size() < ConfigurationConstants.TOTAL_CAR_MIN_LIMIT
                || cars.size() > ConfigurationConstants.TOTAL_CAR_MAX_LIMIT) {
            throw new IllegalArgumentException(OUT_OF_CAPACITY);
        }
    }

    public List<String> findWinners() {
        int maxPosition = calculateMaxPosition();
        List<String> winners = cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(winners);
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(0);
    }

    public List<Car> doRace() {
        cars.forEach(Car::moveCar);
        return Collections.unmodifiableList(cars);
    }
}
