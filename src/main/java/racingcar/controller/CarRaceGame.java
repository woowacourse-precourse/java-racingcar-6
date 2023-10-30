package racingcar.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameManager;
import racingcar.utility.CarRaceGameUtility;
import racingcar.validator.Validator;
import racingcar.view.CarRaceGameView;

public class CarRaceGame {
    private GameManager gameManager;
    private CarRaceGameUtility carRaceGameUtility;

    private CarRaceGame() {
    }

    public static void run() {
        startGame();
    }

    public static void startGame() {
        String carNames = CarRaceGameView.startGameView();
        List<String> carNameList = CarNamesToList(carNames);
        List<Car> carImplList = setUpCar(carNameList);
        validateCarName(carNameList);

        String attemptNumberString = CarRaceGameView.attemptNumberView();

        GameManager.setAttemptNumber(Integer.parseInt(attemptNumberString));
        GameManager.setCarImplList(carImplList);

        CarRaceGameUtility.startCarRaceGame();
    }

    private static List<Car> setUpCar(List<String> carNameList) {
        List<Car> carImplList = new ArrayList<Car>();

        for (String carName : carNameList) {
            carImplList.add(new Car(carName));
        }
        return carImplList;
    }

    private static List<String> CarNamesToList(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    public static void validateCarName(List<String> carNameList) {
        for (String carName : carNameList) {
            Validator.carNameStringLength(carName);
            Validator.isStringEmpty(carName);
        }
    }
}

