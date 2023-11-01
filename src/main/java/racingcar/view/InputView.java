package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.messages.ViewMessage.INPUT_CAR_NAMES;
import static racingcar.messages.ViewMessage.INPUT_TRY_COUNT;

public class InputView {
    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String inputCarNames() {
        System.out.print(INPUT_CAR_NAMES);
        return readLine().strip();
    }

    public String inputTryCount() {
        System.out.print(INPUT_TRY_COUNT);
        return readLine().strip();
    }
}
