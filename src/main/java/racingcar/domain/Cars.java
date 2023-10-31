package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;
import racingcar.util.RandomNumberGenerator;

import java.util.*;

public class Cars {

    private List<Car> cars;

    public Cars(String inputNames) {

        String[] splitNames = splitInputNames(inputNames);
        validateBlank(splitNames);

        String[] trimNames = trimNames(splitNames);
        validateCarCount(trimNames);
        validateDuplicates(trimNames);


        cars = Arrays.stream(trimNames)
                .map(name -> new Car(name))
                .toList();
    }

    private String[] splitInputNames(String inputNames) {
        return inputNames.split(",", -1);
    }

    private void validateBlank(String[] names) {
        boolean hasBlank = Arrays.stream(names)
                .anyMatch(name -> StringUtils.isBlank(name));
        if (hasBlank) {
            throw new IllegalArgumentException();
        }
    }

    private String[] trimNames(String[] names) {
        return Arrays.stream(names)
                .map(String::trim)
                .toArray(String[]::new);
    }

    private void validateCarCount(String[] names) {
        if (names.length <= 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicates(String[] names) {
        Set<String> nonDuplicateNames = new HashSet<>();
        Arrays.stream(names)
                .forEach(name -> nonDuplicateNames.add(name));

        if (nonDuplicateNames.size() != names.length) {
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        cars.stream()
                .forEach(car -> car.goOrStop(RandomNumberGenerator.generateRandomNumber()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
