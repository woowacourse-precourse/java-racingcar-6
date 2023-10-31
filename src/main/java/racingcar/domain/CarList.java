package racingcar.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validation.CarNameValidator;

public class CarList {

    private final CarNameValidator carNameValidator;

    private static final String DIVISION_STANDARD = ",";

    private List<Car> carList;

    private CarList(String userInput, CarNameValidator carNameValidator) {
        this.carList = from(userInput);
        this.carNameValidator = carNameValidator;
    }

    public static CarList of(String userInput, CarNameValidator carNameValidator) {
        return new CarList(userInput, carNameValidator);
    }

    private List<Car> from(String userInput) {
        List<String> userInputList = convertStrToList(userInput);
        carNameValidator.validateCarName(userInputList);
        return userInputList.stream()
                .map(name -> Car.from(name))
                .collect(Collectors.toList());
    }

    private List<String> convertStrToList(String userInput) {
        return Arrays.stream(userInput.split(DIVISION_STANDARD))
                .collect(Collectors.toList());
    }
}
