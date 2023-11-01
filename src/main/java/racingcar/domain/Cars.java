package racingcar.domain;

import static racingcar.constant.ErrorMessage.DUPLICATE_INPUT_ERROR;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNames) {
        validateDuplicateInput(carNames);
        carList = carNames.stream().map(Car::new).toList();
    }

    private void validateDuplicateInput(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_ERROR.getMessage());
        }
    }

    public void run(NumberGenerator numberGenerator) {
        for (Car car : carList) {
            int randomNumber = numberGenerator.generate();
            car.run(randomNumber);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> findWinners() {
        int maxDistance = findMaxDistance();

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    private int findMaxDistance() {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .orElseThrow(NoSuchElementException::new)
                .getDistance();
    }
}
