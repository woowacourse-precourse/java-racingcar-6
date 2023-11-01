package racingcar.Controller;

import racingcar.Util.CarNameValidator;
import racingcar.Util.RoundNumberValidator;
import racingcar.model.RacingCars;
import racingcar.view.InputView;


import racingcar.view.InputView;

public class InputController {
    public static RacingCars setRacingCars() {
        try {
            CarNameValidator validation = new CarNameValidator(InputView.carInput());
            return new RacingCars(validation.NAMES);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setRacingCars();
        }
    }

    public static int setRoundNum() {
        try {
            RoundNumberValidator validation = new RoundNumberValidator(InputView.roundInput());
            return Integer.parseInt(validation.ROUND_NUM_STRING);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setRoundNum();
        }
    }
}