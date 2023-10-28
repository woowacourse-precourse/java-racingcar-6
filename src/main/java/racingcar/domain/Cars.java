package racingcar.domain;

import static racingcar.constants.MessageConstant.INVALID_INPUT_MESSAGE;
import static racingcar.constants.MessageConstant.WINNER_NAME_SEPARATOR;
import static racingcar.constants.NumberConstant.RANDOM_NUMBER_LIMIT;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.Randoms;

public class Cars {

    private final List<Car> cars;

    public static Cars of(final List<String> names) {
        return new Cars(names);
    }

    private Cars(final List<String> names) {
        validate(names);
        cars = convertToCars(names);
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

    public String selectWinnerNames() {
        int maxMove = receiveMaxMove();
        List<String> winnerNames = selectWinnerNames(maxMove);
        return joinWinnerNames(winnerNames);
    }

    private String joinWinnerNames(final List<String> winnerNames) {
        return String.join(WINNER_NAME_SEPARATOR, winnerNames);
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

        Car targetCar = getCarByIndex(index).increaseMove();
        moveForward(index, targetCar);
    }

    private void moveForward(final int index, final Car targetCar) {
        cars.set(index, targetCar);
    }

    private boolean isRandomNumberNotInRange() {
        return Randoms.pickNumberInRange() < RANDOM_NUMBER_LIMIT;
    }

    private Car getCarByIndex(final int index) {
        return cars.get(index);
    }

    private List<Car> convertToCars(final List<String> names) {
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
