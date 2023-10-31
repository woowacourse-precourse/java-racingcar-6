package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.Parser;
import racingcar.utils.numbergenerators.RandomNumberGenerator;
import racingcar.utils.validators.CarNamesValidator;

public class Cars {
    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public Cars(String carNames) {
        CarNamesValidator.validateCarNames(carNames);
        this.cars = makeCarList(Parser.parseCarNames(carNames));
    }

    // 자동차 이름 배열 -> 자동차 객체 배열로 변경
    private List<Car> makeCarList(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    // 우승 자동차 배열 반환
    public List<String> getWinnerCars() {
        int maxDistance = findMaxDistance();
        return filterWinnerCars(maxDistance);
    }

    // 최대로 움직인 자동차 탐색
    private List<String> filterWinnerCars(int maxDistance) {
        return cars.stream()
                .filter(car -> car.isMaxDistance(maxDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    // 최대로 움직인 횟수 탐색
    private int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();
    }

    // 전체 자동차 움직이기
    public void moveCars() {
        cars.forEach(car -> car.move(randomNumberGenerator));
    }

    public List<Car> getCars() {
        return cars;
    }
}