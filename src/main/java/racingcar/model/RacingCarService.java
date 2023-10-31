package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.model.car.CarList;

public class RacingCarService {
    private CarList carList;

    public Integer parsingTryNumber(String userInputTryNumber) {
        InputValidator.validateNumber(userInputTryNumber);
        return Integer.parseInt(userInputTryNumber);
    }

    public List<String> createCarNameList(String userInputCarNames) {
        return Arrays.stream(userInputCarNames.split(",")).toList();
    }

    public void createCarList(List<String> carNameList) {
        InputValidator.validateEmptyName(carNameList);
        InputValidator.validateNameLength(carNameList);
        InputValidator.validateDuplication(carNameList);
        carList = new CarList(carNameList);
    }

    public void move() {
        carList.move();
    }

    public String racingResult() {
        return carList.showCarList();
    }

    public String findWinner() {
        return carList.findMaxPositionCars();
    }
}
