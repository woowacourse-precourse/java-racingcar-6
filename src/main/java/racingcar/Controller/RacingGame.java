package racingcar.Controller;

import racingcar.model.CarInfo;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.validation;

public class RacingGame {

    public int convertStringToInt(String num) {
        validation.checkTryNumber(num);
        return Integer.parseInt(num);
    }
}
