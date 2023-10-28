package racingcar.controller;

import racingcar.model.InputValueValidator;
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
        validator.checkMovementCount(count);
    }
}
