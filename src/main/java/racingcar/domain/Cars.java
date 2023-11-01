package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;
import racingcar.util.RandomNumberGenerator;

import java.util.*;

public class Cars {

    private static final String NAMING_BLANK_ERROR_MESSAGE = "공백은 자동차 이름이 될 수 없습니다.";
    private static final String CAR_COUNT_ERROR_MESSAGE = "1개의 자동차는 경주를 할 수 없습니다.";
    private static final String NAMING_DUPLICATES_ERROR_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    private final RandomNumberGenerator randomNumberGenerator;
    private List<Car> cars;

    public Cars(String inputNames, RandomNumberGenerator randomNumberGenerator) {
        List<String> names = convertStringToList(inputNames);
        validateBlank(names);

        List<String> trimNames = trimNames(names);
        validateCarCount(trimNames);
        validateDuplicates(trimNames);

        cars = trimNames.stream()
                .map(Car::new)
                .toList();

        this.randomNumberGenerator = randomNumberGenerator;
    }

    private List<String> convertStringToList(String inputNames) {
        return Arrays.asList(inputNames.split(",", -1));
    }

    private void validateBlank(List<String> names) {
        boolean hasBlank = names.stream()
                .anyMatch(StringUtils::isBlank);
        if (hasBlank) {
            throw new IllegalArgumentException(NAMING_BLANK_ERROR_MESSAGE);
        }
    }

    private List<String> trimNames(List<String> names) {
        return names.stream()
                .map(String::trim)
                .toList();
    }

    private void validateCarCount(List<String> names) {
        if (names.size() <= 1) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateDuplicates(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(NAMING_DUPLICATES_ERROR_MESSAGE);
        }
    }

    public void play() {
        cars.stream()
                .forEach(car -> car.MoveOrStop(randomNumberGenerator.generateRandomNumber()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
