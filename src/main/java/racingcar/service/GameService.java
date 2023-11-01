package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Constants;
import racingcar.domain.Winner;
import racingcar.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class GameService {

    public static List<Car> createCar(List<String> carNames) {

        return carNames.stream()
                .map(CarName::new)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCar(List<Car> cars) {
        cars.forEach(car -> car.move(RandomUtils.createRandomNumber(Constants.MIN_RANDOM_NUMBER, Constants.MAX_RANDOM_NUMBER)));
    }

    public Winner findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return findWinnerCar(cars, maxPosition);
    }

    private int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(Integer.MIN_VALUE); // 예외처리하기
    }

    private Winner findWinnerCar(List<Car> cars, int maxPosition) {
        List<String> winnerCarNames = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        return new Winner(winnerCarNames);
    }
}
