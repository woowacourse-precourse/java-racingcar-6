package racingcar.service.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// TODO: for문 람다식으로 수정
// TODO: RacingCars가 검증해야할 부분 방어 코드 작성
// TODO: RacingCars public 메서드 단위 테스트
// TODO: getter 없애도록 고민해볼 것
public class RacingCars {
    private static final String DUPLICATE_EXISTS = "중복된 이름이 존재합니다.";
    private final List<Car> cars;

    public RacingCars(List<String> carNames, Engine engine) {
        List<Car> cars = mapToCarList(carNames, engine);
        validateDuplicate(cars, carNames);
        this.cars = cars;
    }

    private List<Car> mapToCarList(List<String> carNames, Engine engine) {
        return carNames.stream()
                .map(carName -> new Car(carName, engine))
                .distinct()
                .collect(Collectors.toList());
    }

    private void validateDuplicate(List<Car> cars, List<String> carNames) {
        if (cars.size() != carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXISTS);
        }
    }

    public List<Car> findWinners() {
        int maxTotalMoveCount = calculateMaxTotalMoveCount();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getTotalMoveCount() == maxTotalMoveCount) {
                winners.add(car);
            }
        }
        return Collections.unmodifiableList(winners);
    }

    private int calculateMaxTotalMoveCount() {
        int maxTotalMoveCount = 0;
        for (Car car : this.cars) {
            maxTotalMoveCount = Math.max(car.getTotalMoveCount(), maxTotalMoveCount);
        }
        return maxTotalMoveCount;
    }

    public List<Car> doRace() {
        for (Car car : this.cars) {
            car.moveCar();
        }
        return Collections.unmodifiableList(cars);
    }
}
