package racingcar.controller;

import racingcar.model.CarNameValidator;
import racingcar.model.RacingCars;
import racingcar.model.RoundNumValidator;
import racingcar.view.InputView;

public class InputController {
    public static RacingCars setRacingCars() {
        CarNameValidator validator = new CarNameValidator(InputView.inputCarName());

        if (validator.validate()) {
            return new RacingCars(validator.NAMES);
        } else {
            return setRacingCars();
        }
//        try {
//            CarNameValidator validator = new CarNameValidator(InputView.inputCarName());
//            return new RacingCars(validator.NAMES);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            return setRacingCars();
//        }
    }
    public static int setRoundNum() {
//        RoundNumValidator validator = new RoundNumValidator(InputView.inputNumOfRounds());
//        return Integer.parseInt(validator.ROUND_NUM_STRING);
        try {
            RoundNumValidator validator = new RoundNumValidator(InputView.inputNumOfRounds());
            return Integer.parseInt(validator.ROUND_NUM_STRING);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setRoundNum();
        }
    }
}
