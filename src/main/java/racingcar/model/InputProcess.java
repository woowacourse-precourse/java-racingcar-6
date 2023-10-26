package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

public class InputProcess {
    InputView inputView = new InputView();

    public String getCarName() {
        inputView.carInput();
        return Console.readLine();
    }

    public String getRepeatNumber() {
        inputView.repeatNumberInput();
        return Console.readLine();
    }
}
