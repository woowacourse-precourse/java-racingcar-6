package racingcar.controller;


import static racingcar.constant.GameConstants.EXECUTION_RESULT;

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
        CarRaceGameView.printStartGame();
        dealWithCarNames(CarRaceGameView.receiveCarNames());

        CarRaceGameView.printAttemptNumber();
        executeCarRaceGame(CarRaceGameView.receiveAttemptNumber());
    }

    public static void dealWithCarNames(String carNames) {
        setUpCar(makeCarNamesToList(carNames));
    }


    private static void setUpCar(List<String> carNameList) {
        for (String carName : carNameList) {
            GameManager.addCarImpl(new Car(carName));
        }
    }

    public static List<String> makeCarNamesToList(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        validateCarName(carNameList);

        return carNameList;
    }

    public static void validateCarName(List<String> carNameList) {
        Validator.checkCarNameDuplication(carNameList);
        for (String carName : carNameList) {
            Validator.isLessThanFiveLetter(carName);
            Validator.isEmptyString(carName);
        }
    }

    public static void executeCarRaceGame(int roundNumber) {
        System.out.println(EXECUTION_RESULT);

        for (int i = 0; i < roundNumber; i++) {
            CarRaceGameUtility.executeCarRaceGameOneRound();
        }
        CarRaceGameView.printGameResult(CarRaceGameUtility.findWinner(GameManager.getCarImplList()));
    }
}

