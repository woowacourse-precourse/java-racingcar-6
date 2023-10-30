package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.model.car.CarList;
import racingcar.model.car.RandomNumber;
import racingcar.model.car.RandomUtil;

public class RacingCarService {
    private RandomUtil randomUtil = new RandomNumber();
    private CarList carList;

    public CarList getCarList() {
        return carList;
    }

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
        carList = new CarList(carNameList, randomUtil);
    }

    public void raceOneStep() {
        carList.move();
    }

    public String raceOneStepResult() {
        return carList.translateRacingCarResult();
    }

    public String findWinnerByCarPosition() {
        return carList.translateMaxPositionCars();
    }
}
