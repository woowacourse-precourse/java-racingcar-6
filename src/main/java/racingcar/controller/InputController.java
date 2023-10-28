package racingcar.controller;

import racingcar.model.CarValidation;
import racingcar.model.RacingCars;
import racingcar.view.InputView;

public class InputController {

    public static RacingCars getCarNames() {
        CarValidation validation = new CarValidation(InputView.carInput());
        return new RacingCars(validation.carNames);
    }

    public static int getRoundCount(){
        return Integer.parseInt(InputView.roundInput());
    }
}
