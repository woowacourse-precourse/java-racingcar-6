package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.validation.CarInputValidate;

public class InputManager {
    private final int gameProcessCount;
    private final List<Car> parsedCarList;

    public InputManager(int gameProcessCount, String inputCarList) {
        this.gameProcessCount = gameProcessCount;
        this.parsedCarList = parseCarList(inputCarList);
    }

    public int getGameProcessCount() {
        return gameProcessCount;
    }

    public List<Car> getParsedCarList() {
        return parsedCarList;
    }

    private List<Car> parseCarList(String carList) {
        String[] carNames = carList.split(",");

        List<Car> cars = Arrays.stream(carNames)
                .peek(CarInputValidate::carNameLengthValidate)
                .map(Car::new)
                .collect(Collectors.toList());

        CarInputValidate.carDuplicateCheck(carNames);
        return cars;
    }
}