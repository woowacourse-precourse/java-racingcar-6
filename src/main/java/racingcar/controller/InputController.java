package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCars;
import racingcar.utils.CarInputValidator;
import racingcar.utils.RoundInputValidator;
import racingcar.view.InputView;

public class InputController {
    public static RacingCars getRacingCars(){
        String input = InputView.carInput();
        CarInputValidator.validate(input);
        return new RacingCars(CarInputValidator.split(input));
    }
    public static int getRound(){
        String input = InputView.roundInput();
        RoundInputValidator.validate(input);
        return Integer.parseInt(input);
    }
}
