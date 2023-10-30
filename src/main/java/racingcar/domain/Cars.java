package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;
import racingcar.util.RandomNumberGenerator;

import java.util.*;

public class Cars {

    private List<Car> cars;

    public Cars(String inputNames) {
        String[] splitNames = inputNames.split(",", -1);
        validateBlank(splitNames);

        String[] trimNames = trimNames(splitNames);
        validateDuplicateName(trimNames);

        cars = Arrays.stream(trimNames)
                .map(name -> new Car(name))
                .toList();
    }

    private void validateBlank(String[] names) {
        boolean hasBlank = Arrays.stream(names)
                .filter(name -> StringUtils.isBlank(name))
                .findFirst()
                .isPresent();
        if (hasBlank) {
            throw new IllegalArgumentException();
        }
    }

    private String[] trimNames(String[] names) {
        return Arrays.stream(names)
                .map(String::trim)
                .toArray(String[]::new);
    }

    private void validateDuplicateName(String[] names) {
        Set<String> notDuplicateNames = new HashSet<>();
        Arrays.stream(names)
                .forEach(name -> notDuplicateNames.add(name));

        if (notDuplicateNames.size() != names.length) {
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
