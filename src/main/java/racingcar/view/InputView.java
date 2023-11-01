package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.view.PrintMessage.ASK_CAR_NAMES;
import static racingcar.view.PrintMessage.ASK_COUNT_TO_TRY;

public class InputView {

    private InputView() {}

    public static String inputCarNames() {
        OutputView.printMessage(ASK_CAR_NAMES);
        return Console.readLine();
    }

    public static int inputTryCount() {
        OutputView.printMessage(ASK_COUNT_TO_TRY);
        return Integer.parseInt(Console.readLine());
    }
}
