package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.Randoms;

public class Cars {

    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다.";
    private static final int RANDOM_NUMBER_LIMIT = 4;

    private final List<Car> cars;

    public static Cars of(List<String> names) {
        return new Cars(names);
    }

    private Cars(List<String> names) {
        validate(names);
        cars = convertToCars(names);
    }

    public List<String> getCurrentState() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }

    public void evaluateCondition() {
        for (int index = 0; index < cars.size(); index++) {
            conditionalMove(index);
        }
    }

    private void conditionalMove(int index) {
        if (Randoms.pickNumberInRange() < RANDOM_NUMBER_LIMIT) {
            return;
        }

        Car targetCar = getCarByIndex(index).increaseForwardCount();
        cars.set(index, targetCar);
    }

    private Car getCarByIndex(int index) {
        return cars.get(index);
    }

    private List<Car> convertToCars(List<String> names) {
        return names.stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }

    private void validate(List<String> names) {
        checkInput(names);
        checkDuplicate(names);
    }

    private void checkInput(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private void checkDuplicate(List<String> names) {
        if (hasDuplicate(names)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean hasDuplicate(List<String> names) {
        long count = names.stream()
                .distinct()
                .count();

        return names.size() != count;
    }
}
