package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constant.Message.*;

public class InputView {
    public static String readCarNames(){
        OutputView outputView = new OutputView();
        outputView.println(INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public static String readTryToMoveTurnCount() {
        OutputView outputView = new OutputView();
        outputView.println(INPUT_TRY_COUNT_MESSAGE);
        return Console.readLine();
    }
}
