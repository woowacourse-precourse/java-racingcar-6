package controller;

import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;
import model.TransformRacingValue;
import model.ValidateRacingValue;
import utility.ValidateException;

public class RacingCarGameManager {
    public static void racingStart() {
        List<String> carName;
        List<Integer> raceResult = new ArrayList<>();
        String carNameBundle;
        int numberOfMatch;

        OutputView.racingCarName();
        carNameBundle = InputView.racingCarName();
        OutputView.numberOfRacing();
        numberOfMatch = Integer.parseInt(InputView.numberOfMatch());
        carName = TransformRacingValue.carNameInputToList(carNameBundle);
        ValidateException.racingCarNameInvalid(carName);
        raceResult = TransformRacingValue.raceResultListReset(carName.size(), raceResult);
        for (int i = 0; i < numberOfMatch; i++) {
            ValidateRacingValue.racingResult(carName, raceResult);
            OutputView.racingResult(carName, raceResult);
        }
        ValidateRacingValue.racingWinner(carName, raceResult);
        OutputView.racingWinner(carName);
    }


}
