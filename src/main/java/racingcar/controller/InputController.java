package racingcar.controller;

import racingcar.model.CarNameValidator;
import racingcar.model.RacingCars;
import racingcar.model.RoundNumValidator;
import racingcar.view.InputView;

public class InputController {
    public static RacingCars setupRacingCars() {
        try {
            CarNameValidator validation = new CarNameValidator(InputView.carInput());
            return new RacingCars(validation.NAMES);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setupRacingCars();
        }
    }

    public static int getNumberOfRounds() {
        try {
            RoundNumValidator validation = new RoundNumValidator(InputView.roundInput());
            return Integer.parseInt(validation.ROUND_NUM_STRING);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getNumberOfRounds();
        }
    }
}
