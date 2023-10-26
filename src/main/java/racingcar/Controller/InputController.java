package racingcar.Controller;

import java.util.List;
import java.util.regex.Pattern;
import racingcar.Constants;
import racingcar.Model.CarValidation;
import racingcar.Model.RacingCars;
import racingcar.Util;
import racingcar.View.InputView;

public class InputController {

    public static RacingCars getCarNames() {
        CarValidation validation = new CarValidation(InputView.carInput());
    System.out.println(validation);
        return new RacingCars();
    }

    public static int getRoundCount(){
        return Integer.parseInt(InputView.roundInput());
    }
}
