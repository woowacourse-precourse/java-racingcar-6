package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.StringConstant;
import racingcar.util.NumberGenerator;
import racingcar.validation.CarNameValidator;

public class CarList {

    private final NumberGenerator numberGenerator;

    private List<Car> carList;

    private CarList(String userInput, NumberGenerator numberGenerator) {
        this.carList = create(userInput);
        this.numberGenerator = numberGenerator;
    }

    public static CarList from(String userInput) {
        return new CarList(userInput, new NumberGenerator());
    }

    private List<Car> create(String userInput) {
        List<String> userInputList = convertStrToList(userInput);
        CarNameValidator.validateCarName(userInputList);

        return userInputList.stream()
                .map(name -> Car.from(name))
                .collect(Collectors.toList());
    }

    private List<String> convertStrToList(String userInput) {
        return Arrays.stream(userInput.split(StringConstant.DIVISION_STANDARD.getMessage()))
                .collect(Collectors.toList());
    }

    public void printGameProceed(int gameCount) {
        for (int count = 0; count < gameCount; count++) {
            for (Car carList : carList) {
                carList.movePosition(numberGenerator.generateRandomNumber());
                carList.printCarPosition();
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
