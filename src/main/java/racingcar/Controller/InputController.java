package racingcar.Controller;

import racingcar.Model.CarValidation;
import racingcar.Model.RacingCars;
import racingcar.View.InputView;

public class InputController {

    public static RacingCars getCarNames() {
        CarValidation validation = new CarValidation(InputView.carInput());
        return new RacingCars(validation.carNames);
    }

    public static int getRoundCount(){
        return Integer.parseInt(InputView.roundInput());
    }
}
