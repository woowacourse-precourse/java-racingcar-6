package racingcar.domain.gameInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.validation.CarInputValidate;

public class InputManager {
    private final int gameProcessCount;
    private final List<Car> parsedCarList;

    public InputManager(int gameProcessCount, List<Car> inputCarList) {
        this.gameProcessCount = gameProcessCount;
        this.parsedCarList = inputCarList;
    }

    public int getGameProcessCount() {
        return gameProcessCount;
    }

    public List<Car> getParsedCarList() {
        return parsedCarList;
    }
}