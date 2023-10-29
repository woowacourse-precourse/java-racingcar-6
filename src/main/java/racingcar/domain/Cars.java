package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateSize(cars);
        validateDuplicated(cars);
        this.cars = cars;
    }

    private void validateSize(List<Car> cars) {
        if (invalidSize(cars)) {
            throw new IllegalArgumentException("[ERROR] 자동차는 2대 이상 10대 이하만 가능합니다.");
        }
    }

    private void validateDuplicated(List<Car> cars) {
        List<String> carNames = getCarNames(cars);
        for (int i = 0; i < carNames.size(); i++) {
            throwIfContainsDuplicatedName(carNames, i);
        }
    }

    private boolean invalidSize(List<Car> cars) {
        return !(2 <= cars.size() && cars.size() <= 10);
    }

    private List<String> getCarNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

    private void throwIfContainsDuplicatedName(List<String> carNames, int i) {
        List<String> remainingCarNames = carNames.subList(i + 1, carNames.size());
        if (remainingCarNames.contains(carNames.get(i))) {
            throw new IllegalArgumentException("[ERROR] 중복되는 자동차 이름이 존재합니다.");
        }
    }

    public MoveResult move(RandomNumberGenerator numberGenerator) {
        List<Integer> forwardCounts = new ArrayList<>();
        for (Car car : cars) {
            int forwardCount = car.move(numberGenerator.generate());
            forwardCounts.add(forwardCount);
        }
        return new MoveResult(getCarNames(cars), forwardCounts);
    }

    public List<Car> getCarsWithMaxForwardCount() {
        int maxForwardCount = getMaxForwardCountOfCars();
        return cars.stream()
                .filter(car -> car.isForwardCountSameAs(maxForwardCount))
                .toList();
    }

    private int getMaxForwardCountOfCars() {
        return cars.stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElseThrow();
    }
}
