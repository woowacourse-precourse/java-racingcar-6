package racingcar.RacingGame;

import racingcar.model.CarInfo;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.validation;

public class racingStart {

    public int convertStringToInt(String num) {
        validation.checkTryNumber(num);
        return Integer.parseInt(num);
    }
}
