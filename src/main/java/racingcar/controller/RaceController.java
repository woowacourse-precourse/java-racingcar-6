package racingcar.controller;

import racingcar.model.InputValueValidator;
import racingcar.model.RaceTrack;
import racingcar.view.UserInputValue;

public class RaceController {

    InputValueValidator validator = new InputValueValidator();

    public RaceController() {
    }

    public void startRace() {
        String carName = UserInputValue.inputCarName();
        String[] carNames = validator.changeArrayType(carName);
        validator.checkNameValidation(carNames);
        String count = UserInputValue.inputMovementCount();
        int countNum = Integer.parseInt(count);
        validator.checkMovementCount(count);

        RaceTrack raceTrack = new RaceTrack(carNames);
        raceTrack.printCarNames();
        // "-" 길이가 count가 될 때까지 '반복'한다
        raceTrack.race(countNum);


    }
}
