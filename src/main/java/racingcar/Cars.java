package racingcar;

import racingcar.config.GameConfig;
import racingcar.exception.DuplicateCarNamesException;
import racingcar.exception.ExceedCarNameLengthException;
import racingcar.exception.NotExistCarsException;

import java.util.*;
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

    public List<Car> getWinners() {
        Integer maxPosition = Collections.max(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));

        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
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
            throw new NotExistCarsException();
        }
    }

    private void validateCarNamesLength(final String splitCarName) {
        if(splitCarName.length() > GameConfig.LIMIT_CAR_NAME_LENGTH){
            throw new ExceedCarNameLengthException();
        }
    }

    private void validateDuplicateCarNames(final List<String> splitCarNames) {
        int carNamesCount = splitCarNames.size();
        int distinctCarNamesCount = new HashSet<>(splitCarNames).size();

        if (carNamesCount != distinctCarNamesCount) {
            throw new DuplicateCarNamesException();
        }
    }
}
