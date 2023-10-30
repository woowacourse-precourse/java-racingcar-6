package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.NumberGenerator;

public class Cars {

    private static final int MIN_CARS_SIZE = 2;
    private static final int MAX_CARS_SIZE = 10;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateSize(cars);
        validateDuplicatedName(cars);
        this.cars = cars;
    }

    private void validateSize(List<Car> cars) {
        if (invalidSize(cars)) {
            throw new IllegalArgumentException("[ERROR] 자동차는 %d대 이상 %d대 이하만 가능합니다."
                    .formatted(MIN_CARS_SIZE, MAX_CARS_SIZE));
        }
    }

    private boolean invalidSize(List<Car> cars) {
        return !(MIN_CARS_SIZE <= cars.size() && cars.size() <= MAX_CARS_SIZE);
    }

    private void validateDuplicatedName(List<Car> cars) {
        List<String> carNames = getCarNames(cars);
        for (int i = 0; i < carNames.size(); i++) {
            throwIfContainsDuplicatedName(carNames, i);
        }
    }

    private void throwIfContainsDuplicatedName(List<String> carNames, int i) {
        List<String> remainingCarNames = carNames.subList(i + 1, carNames.size());
        if (remainingCarNames.contains(carNames.get(i))) {
            throw new IllegalArgumentException("[ERROR] 중복되는 자동차 이름이 존재합니다.");
        }
    }

    public MoveResult handleCarMovement(NumberGenerator numberGenerator) {
        List<Integer> forwardCounts = new ArrayList<>();
        cars.forEach(car ->
                forwardCounts.add(car.move(numberGenerator.generate()))
        );
        return new MoveResult(getCarNames(cars), forwardCounts);
    }

    private List<String> getCarNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .toList();
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
