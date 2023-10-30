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
        List<Integer> raceResult = new ArrayList<>();
        String carNameBundle;
        int numberOfMatch;

        Output.carNameManuel();
        carNameBundle = Input.carName();
        carName = Transform.carNameToList(carNameBundle);
        ValidateException.racingCarNameInvalid(carName);
        Output.numberOfRacingManuel();
        numberOfMatch = Integer.parseInt(Input.numberOfRacing());
        raceResult = Transform.resultListReset(carName.size(), raceResult);
        for (int i = 0; i < numberOfMatch; i++) {
            Validation.racingResult(carName, raceResult);
            Output.racingResult(carName, raceResult);
        }
        Validation.racingWinner(carName, raceResult);
        Output.racingWinner(carName);
    }


}
