package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.output.RacingOutputView;

public class RacingInputView {

    public String inputCarName() {
        RacingOutputView.outputCarName();
        return Console.readLine();
    }

}
