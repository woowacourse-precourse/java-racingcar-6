package controller;

import java.util.ArrayList;
import java.util.List;
import view.Input;
import view.Output;
import model.Transform;
import model.Validation;
import utility.ValidateException;

public class RacingCarGameManager {
    public static void racingStart() {
        List<String> carName;
        List<Integer> raceResult;
        int numberOfRacing;
        carName = carNameInputProcess();
        numberOfRacing = numberOfRacingProcess();
        raceResult = gameLogicProcess(carName, numberOfRacing);
        racingWinnerOutputProcess(carName, raceResult);
    }

    public static List<String> carNameInputProcess() {
        String carNameBundle;
        Output.carNameManuel();
        carNameBundle = Input.carName();
        List<String> carName = Transform.carNameToList(carNameBundle);
        ValidateException.racingCarNameInvalid(carName);
        return carName;
    }

    public static int numberOfRacingProcess() {
        int numberOfRacing;
        Output.numberOfRacingManuel();
        numberOfRacing = Integer.parseInt(Input.numberOfRacing());
        return numberOfRacing;
    }

    public static List<Integer> gameLogicProcess(List<String> carName, int numberOfRacing) {
        List<Integer> raceResult = new ArrayList<>();
        Transform.resultListReset(carName.size(), raceResult);
        for (int i = 0; i < numberOfRacing; i++) {
            Validation.racingResult(carName, raceResult);
            Output.racingResult(carName, raceResult);
        }
        return raceResult;
    }

    public static void racingWinnerOutputProcess(List<String> carName, List<Integer> raceResult) {
        Validation.racingWinner(carName, raceResult);
        Output.racingWinner(carName);
    }
}
