package racingcar.service;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

public class GameService {
    public List<Car> createCars(String inputCarNames) {
        List<String> carNames = Arrays.stream(inputCarNames.split(",")).toList();
        List<Car> cars = carNames.stream()
                .filter(this::validateCarName)
                .map(Car::new)
                .toList();

        return cars;
    }

    private boolean validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름이 5자를 초과합니다.");
        }

        return true;
    }
}
