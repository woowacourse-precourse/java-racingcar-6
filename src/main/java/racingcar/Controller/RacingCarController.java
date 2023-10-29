package racingcar.Controller;

import java.util.List;
import racingcar.Util.InputValidator;
import racingcar.View.InputView;

public class RacingCarController {

    public void initRacingCarGame(){
        List<String> carNameList = InputView.inputRacingCarName();
        InputValidator.checkCarNameLength(carNameList);
        String racingRoundTimes = InputView.inputRacingRoundTimes();
        InputValidator.checkIsNumber(racingRoundTimes);
    }
}
