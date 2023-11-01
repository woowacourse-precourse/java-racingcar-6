package racingcar.model;

import java.util.List;
import racingcar.model.car.CarList;
import racingcar.model.car.RandomUtil;

public class RacingCarService {
    private RandomUtil randomUtil;
    private static final String SEPARATOR = ",";
    private CarList carList;

    public RacingCarService(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    public Integer parsingTryNumber(String userInputTryNumber) {
        InputValidator.validateNumber(userInputTryNumber);
        return Integer.parseInt(userInputTryNumber);
    }

    public List<String> splitCarNames(String userInputCarNames) {
        return List.of(userInputCarNames.split(SEPARATOR));
    }

    public void createCarList(String userInputCarNames) {
        List<String> carNameList = splitCarNames(userInputCarNames);
        InputValidator.validateEmptyName(carNameList);
        InputValidator.validateNameLength(carNameList);
        InputValidator.validateDuplication(carNameList);
        carList = new CarList(carNameList, randomUtil);
    }

    public void move() {
        carList.move();
    }

    public String racingResult() {
        return carList.showCarList();
    }

    public String findWinner() {
        return String.join(", ", carList.findMaxPositionCars());
    }
}
