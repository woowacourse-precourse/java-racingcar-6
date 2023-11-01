package racingcar.view;

import static racingcar.view.IOMessage.ASK_CAR_NAMES;
import static racingcar.view.IOMessage.ASK_COUNT_TO_TRY;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {}

    public static String inputCarNames() {
        OutPutView.printIOMessage(ASK_CAR_NAMES);
        return Console.readLine();
    }

    public static int inputTryCount() {
        OutPutView.printIOMessage(ASK_COUNT_TO_TRY);
        return Integer.parseInt(Console.readLine());
    }

}
