package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validation.CarNameValidator;

public class CarList {

    private static final String DIVISION_STANDARD = ",";

    private List<Car> carList;

    private CarList(String userInput) {
        this.carList = create(userInput);
    }

    public static CarList of(String userInput) {
        return new CarList(userInput);
    }

    private List<Car> create(String userInput) {
        List<String> userInputList = convertStrToList(userInput);
        CarNameValidator.validateCarName(userInputList);
        return userInputList.stream()
                .map(name -> Car.from(name))
                .collect(Collectors.toList());
    }

    private List<String> convertStrToList(String userInput) {
        return Arrays.stream(userInput.split(DIVISION_STANDARD))
                .collect(Collectors.toList());
    }

    public void playGame(int gameCount) {
        for (int count = 0; count < gameCount; count++) {
            for (Car carList : carList) {
                carList.play();
                carList.printGameProceed();
            }
            System.out.println();
        }
    }

    public List<String> findWinner() {
        Car maxPositionCar = findMaxPositionCar();

        return carList.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
        return carList.stream()
                .max(Car::compareTo)
                .get();
    }
}
