package racingcar.domain;

import static racingcar.constants.MessageConstant.INVALID_INPUT_MESSAGE;
import static racingcar.constants.NumberConstant.RANDOM_NUMBER_LIMIT;
import static racingcar.utils.Randoms.pickNumberInRange;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public static Cars of(final List<String> names) {
        return new Cars(names);
    }

    private Cars(final List<String> names) {
        validate(names);
        cars = convertToCarList(names);
    }

    public List<String> receiveCurrentRank() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }

    public void applyMovingForward() {
        for (int index = 0; index < cars.size(); index++) {
            conditionalMove(index);
        }
    }

    public List<String> receiveWinnerNames() {
        int maxMove = receiveMaxMove();
        return selectWinnerNames(maxMove);
    }

    private List<String> selectWinnerNames(final int maxMove) {
        return cars.stream()
                .filter(car -> car.compare(maxMove))
                .map(Car::getName)
                .toList();
    }

    private int receiveMaxMove() {
        return cars.stream()
                .map(Car::getMove)
                .max(Integer::compare)
                .orElseThrow();
    }

    private void conditionalMove(final int index) {
        if (isRandomNumberNotInRange()) {
            return;
        }

        Car targetCar = getByIndex(index).increaseMove();
        moveForward(index, targetCar);
    }

    private void moveForward(final int index, final Car targetCar) {
        cars.set(index, targetCar);
    }

    private boolean isRandomNumberNotInRange() {
        return pickNumberInRange() < RANDOM_NUMBER_LIMIT;
    }

    private Car getByIndex(final int index) {
        return cars.get(index);
    }

    private List<Car> convertToCarList(final List<String> names) {
        return names.stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }

    private void validate(final List<String> names) {
        checkInput(names);
        checkDuplicate(names);
    }

    private void checkInput(final List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private void checkDuplicate(final List<String> names) {
        if (hasDuplicate(names)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean hasDuplicate(final List<String> names) {
        return names.size() != countDuplicateNames(names);
    }

    private long countDuplicateNames(final List<String> names) {
        return names.stream()
                .distinct()
                .count();
    }
}
