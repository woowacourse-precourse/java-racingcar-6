package racingcar.domain;

import static java.lang.String.format;
import static racingcar.constant.ErrorMessage.DUPLICATE_INPUT_ERROR;
import static racingcar.constant.ErrorMessage.EMPTY_INPUT_ERROR;
import static racingcar.constant.ErrorMessage.LENGTH_INPUT_ERROR;
import static racingcar.constant.RaceSetting.MAX_CAR_NAME_LENGTH;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNames) {
        validateCarNamesInput(carNames);
        carList = carNames.stream().map(Car::new).toList();
    }

    private void validateCarNamesInput(List<String> carNamesInput) {
        validateEmptyInput(carNamesInput);
        validateLengthInput(carNamesInput);
        validateDuplicateInput(carNamesInput);
    }

    private void validateEmptyInput(List<String> carNamesInput) {
        boolean isEmptyInput = carNamesInput
                .stream()
                .anyMatch(carName -> carName.trim().isEmpty());
        if (isEmptyInput) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR.getMessage());
        }
    }

    private void validateLengthInput(List<String> carNames) {
        boolean isValidCarName = carNames
                .stream()
                .allMatch(carName -> carName.length() <= MAX_CAR_NAME_LENGTH.getValue());

        if (!isValidCarName) {
            throw new IllegalArgumentException(
                    format(LENGTH_INPUT_ERROR.getMessage(), MAX_CAR_NAME_LENGTH.getValue())
            );
        }
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

    public List<Car> getCars() {
        return carList;
    }

    public List<String> findWinners() {
        int maxDistance = carList.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .orElseThrow(NoSuchElementException::new)
                .getDistance();

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }
}
