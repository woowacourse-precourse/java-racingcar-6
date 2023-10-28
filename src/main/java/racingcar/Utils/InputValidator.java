package racingcar.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private final int MAX_NAME_LENGTH = 5;
    private final int MIN_NAME_LENGTH = 1;
    private final int MAX_CAR_NUM = 10;
    private final int MIN_CAR_NUM = 1;
    private final int MAX_TRY_COUNT = 100;
    private final int MIN_TRY_COUNT = 1;
    private final String CAR_NAME_REGEX = "^[a-z0-9]+$";
    private final String ONLY_NUMBER_REGEX = "^[0-9]+$";
    private final String DELIMITER = ",";

    public List<String> validateCarName(String input) {
        List<String> cars = Arrays.stream(input.split(DELIMITER)).toList();

        if (!isProperCarNum(cars)) {
            throw new IllegalArgumentException();
        }

        if (hasDupCarName(cars)) {
            throw new IllegalArgumentException();
        }

        if (!isProperCarNames(cars)) {
            throw new IllegalArgumentException();
        }
        return cars;
    }

    public int validateTryCount(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException();
        }

        int tryCount = Integer.parseInt(input);

        if(! isProperTryCount(tryCount)) {
            throw new IllegalArgumentException();
        }

        return tryCount;
    }

    private boolean isProperCarNames(List<String> cars) {
        for (String car : cars) {
            if (!isProperNameLength(car)) {
                return false;
            }
            if (!isProperCarName(car)) {
                return false;
            }
        }
        return true;
    }

    private boolean isProperCarNum(List<String> cars) {
        return cars.size() >= MIN_CAR_NUM && cars.size() <= MAX_CAR_NUM;
    }

    private boolean isProperNameLength(String car) {
        return car.length() >= MIN_NAME_LENGTH && car.length() <= MAX_NAME_LENGTH;
    }

    private boolean isProperCarName(String car) {
        return car.matches(CAR_NAME_REGEX);
    }

    private boolean hasDupCarName(List<String> cars) {
        return cars.size() != cars.stream().distinct().toList().size();
    }

    private boolean isNumber(String input) {
        return input.matches(ONLY_NUMBER_REGEX);
    }

    private boolean isProperTryCount(int count) {
        return count >= MIN_TRY_COUNT && count <= MAX_TRY_COUNT;
    }
}
