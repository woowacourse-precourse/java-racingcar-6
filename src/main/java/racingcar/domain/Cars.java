package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;
import racingcar.util.RandomNumberGenerator;

import java.util.*;

public class Cars {

    private List<Car> cars;

    public Cars(String inputNames) {
        List<String> names = convertStringToList(inputNames);
        validateBlank(names);

        List<String> trimNames = trimNames(names);
        validateCarCount(trimNames);
        validateDuplicates(trimNames);

        cars = trimNames.stream()
                .map(Car::new)
                .toList();
    }

    private List<String> convertStringToList(String inputNames) {
        return Arrays.asList(inputNames.split(",", -1));
    }

    private void validateBlank(List<String> names) {
        boolean hasBlank = names.stream()
                .anyMatch(StringUtils::isBlank);
        if (hasBlank) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> trimNames(List<String> names) {
        return names.stream()
                .map(String::trim)
                .toList();
    }

    private void validateCarCount(List<String> names) {
        if (names.size() <= 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicates(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        cars.stream()
                .forEach(car -> car.MoveOrStop(RandomNumberGenerator.generateRandomNumber()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
