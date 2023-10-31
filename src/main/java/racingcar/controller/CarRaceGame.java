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
        List<String> carNameList = getCarNameListAndValidate();
        setCarImpls(carNameList);

        CarRaceGameUtility.executeCarRaceGameForNRound(getGameRoundAndValidate());
    }

    public static List<String> getCarNameListAndValidate() {
        CarRaceGameView.printStartGame();
        String carNames = CarRaceGameView.getInput();
        Validator.checkCarNamesForm(carNames);

        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        validateCarName(carNameList);
        return carNameList;
    }

    public static int getGameRoundAndValidate() {
        CarRaceGameView.printAttemptNumber();
        String attemptNumberString = CarRaceGameView.getInput();
        validateGameRoundNumber(attemptNumberString);
        return Integer.parseInt(attemptNumberString);
    }

    private static void setCarImpls(List<String> carNameList) {
        for (String carName : carNameList) {
            GameManager.addCarImpl(new Car(carName));
        }
    }


    public static void validateCarName(List<String> carNameList) {
        Validator.checkCarNameDuplication(carNameList);
        for (String carName : carNameList) {
            Validator.isLessThanFiveLetter(carName);
            Validator.isEmptyString(carName);
        }
    }

    public static void validateGameRoundNumber(String gameRound) {
        Validator.isEmptyString(gameRound);
        Validator.isNumber(gameRound);
        Validator.isMoreThanOne(gameRound);
    }
}

