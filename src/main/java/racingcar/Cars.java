package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(String carNames) {
        this.cars = new ArrayList<>();
        makeCars(carNames);
    }

    private void validateCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }
    }

    private void makeCars(String carNames) {
        validateCarNames(carNames);
        for (String carName : carNames.split(Constant.CAR_NAMES_DELIMITER)) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> toList() {
        return cars;
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}