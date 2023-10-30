package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingInputView {

    public String inputCarName() {
        RacingOutputView.outputCarName();
        return Console.readLine();
    }

    public String inputTryCount() {
        RacingOutputView.outputTryCount();
        return Console.readLine();
    }

}
