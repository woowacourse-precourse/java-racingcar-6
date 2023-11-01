package racingcar.controller;

import racingcar.model.CarNameValidator;
import racingcar.model.RacingCars;
import racingcar.view.InputView;

public class InputController {
    public static RacingCars setRacingCars() {
        try {
            CarNameValidator validator = new CarNameValidator(InputView.inputCarName());
            return new RacingCars(validator.NAMES);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setRacingCars();
        }
    }
}
