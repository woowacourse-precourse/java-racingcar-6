package racingcar.view;

import static racingcar.view.InputMessageType.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {}

    private static class InputViewInstance{
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InputViewInstance.INSTANCE;
    }

    public String enterCarNames() {
        System.out.println(ENTER_CAR_NAMES.getMessage());

        return Console.readLine();
    }

    public String enterRacingCount() {
        System.out.println(ENTER_RACING_COUNT.getMessage());

        return Console.readLine();
    }
}
