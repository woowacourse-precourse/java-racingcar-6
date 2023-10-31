package car;

import console.UserInputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> carList;
    private static final String SPLIT_DELIMITER = ",";
    public Cars(String userInput) {
        this.carList = this.initByStringInput(userInput);
    }

    private List<Car> initByStringInput(String userInput) {
        String[] carNames = userInput.split(SPLIT_DELIMITER);
        return Arrays.stream(carNames)
                .map(String::trim)
                .map(carName -> {
                    UserInputValidator.validate(carName);
                    return new Car(carName);
                })
                .toList();
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }

    public List<String> getCarNames() {
        return carList.stream().map(Car::getName).toList();
    }

    public List<String> getWinnersNames() {
        int maxLocation = carList.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
        return carList.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toList();
    }
    public void move() {
        this.carList.forEach(Car::move);
    }
}