package racingcar.model;

import racingcar.constants.CarConstant;
import racingcar.constants.ErrorMessage;
import racingcar.util.Util;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String[] carNames) {
        validateDuplicatedName(carNames);

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            validateNameLength(name);
            validateIsBlank(name);
            cars.add(Car.from(name));
        }
        return new Cars(cars);
    }

    private static void validateDuplicatedName(String[] carNames) {
        Set<String> names = new HashSet<>();
        boolean hasDuplicates = Arrays.stream(carNames)
                .anyMatch(name -> !names.add(name));

        if (hasDuplicates) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATED_NAME.getMessage());
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > CarConstant.MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_LENGTH.getMessage());
        }
    }

    private static void validateIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_BLANK.getMessage());
        }
    }

    public void playRound() {
        cars.forEach(car -> {
            int randomNumber = Util.generateRandomNumber();
            car.moveForward(randomNumber);
        });
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
