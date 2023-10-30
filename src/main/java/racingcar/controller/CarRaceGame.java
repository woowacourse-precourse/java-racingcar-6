package racingcar.controller;


import static racingcar.constant.GameConstants.EXECUTION_RESULT;

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
        dealWitCarNames(carNames);
        String roundNumberString = CarRaceGameView.attemptNumberView();
        startCarRaceGame(Integer.parseInt(roundNumberString));
    }

    public static void dealWitCarNames(String carNames) {

        setUpCar(CarNamesToList(carNames));
    }


    private static void setUpCar(List<String> carNameList) {
        for (String carName : carNameList) {
            GameManager.addCarImpl(new Car(carName));
        }
    }

    public static List<String> CarNamesToList(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        validateCarName(carNameList);

        return carNameList;
    }

    public static void validateCarName(List<String> carNameList) {
        for (String carName : carNameList) {
            Validator.carNameStringLength(carName);
            Validator.isStringEmpty(carName);
        }
    }

    public static void startCarRaceGame(int roundNumber) {
        System.out.println(EXECUTION_RESULT);

        for (int i = 0; i < roundNumber; i++) {
            CarRaceGameUtility.startCarRaceGameOneRound();
        }
        CarRaceGameView.gameResultView(CarRaceGameUtility.findWinner(GameManager.getCarImplList()));
    }
}

