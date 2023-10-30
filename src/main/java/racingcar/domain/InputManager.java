package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.validation.CarLengthValidate;

public class InputManager {
    private final int gameProcessCount;
    private final String inputCarList;
    private final List<Car> parsedCarList;

    public InputManager(int gameProcessCount, String inputCarList) {
        this.gameProcessCount = gameProcessCount;
        this.inputCarList = inputCarList;
        this.parsedCarList = parseCarList(inputCarList);
    }

    public int getGameProcessCount() {
        return gameProcessCount;
    }

    public List<Car> getParsedCarList() {
        return parsedCarList;
    }

    private List<Car> parseCarList(String carList) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = carList.split(",");
        for (String carName : carNames) {
            CarLengthValidate.carNameLengthValidate(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }
}