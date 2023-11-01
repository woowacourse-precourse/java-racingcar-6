package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import racingcar.constant.ErrorMessage;
import racingcar.exception.RacingCarException;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        validateCars(cars);
        validateDuplication(cars);
        this.cars = cars;
    }

    public static Cars createCarList(String userInput) {
        List<Car> carList = parseCarList(extractNamesList(userInput));

        return new Cars(carList);
    }

    private static List<Car> parseCarList(List<String> names) {
        List<Car> cars = names.stream()
                .map(name -> Car.createCar(new CarName(name), 0))
                .collect(Collectors.toList());

        return Collections.unmodifiableList(cars);
    }

    private static List<String> extractNamesList(String userInput) {
        return List.of(userInput.split(","));
    }

    public List<CarName> findWinnerCars() {
        int maximumDistance = findMaximumDistance();

        return cars.stream()
                .filter(car -> car.isSameDistance(maximumDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaximumDistance() {
        int maximumDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return maximumDistance;
    }

    public void moveAllCars() {
        cars.forEach(Car::moveByGeneratedNumber);
    }

    public Map<CarName, Integer> convertCarToMap() {
        Map<CarName, Integer> carResult = cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getDistance));

        return carResult;
    }

    private void validateCars(List<Car> carList) {
        if (isJustOneCar(carList)) {
            throw new RacingCarException(ErrorMessage.SINGLE_COUNT);
        }
    }

    private boolean isJustOneCar(List<Car> carList) {
        return carList.size() < 2;
    }

    private void validateDuplication(List<Car> carList) {
        Set<Car> carSet = new HashSet<>(carList);

        throwErrorIfDuplicated(carList, carSet);
    }

    private void throwErrorIfDuplicated(List<Car> carList, Set<Car> carSet) {
        if (carList.size() != carSet.size()) {
            throw new RacingCarException(ErrorMessage.DUPLICATED_VALUES);
        }
    }
}
