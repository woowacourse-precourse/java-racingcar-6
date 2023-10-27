package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final String carNames) {
        validate(carNames);

        this.cars = Arrays.stream(carNames.split(","))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private void validate(final String carNames) {
        List<String> splitCarNames = new ArrayList<>(Arrays.asList(carNames.split(",")));

        splitCarNames.stream()
                .forEach(carName -> validateCarNamesLength(carName));
        validateNotExistCar(splitCarNames);
        validateDuplicateCarNames(splitCarNames);
    }

    private void validateNotExistCar(final List<String> splitCarNames) {
        if (splitCarNames.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNamesLength(final String splitCarName) {
        if(splitCarName.length() > 5){
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateCarNames(final List<String> splitCarNames) {
        int carNamesCount = splitCarNames.size();
        int distinctCarNamesCount = new HashSet<>(splitCarNames).size();

        if (carNamesCount != distinctCarNamesCount) {
            throw new IllegalArgumentException();
        }
    }
}
