package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import racingcar.global.GeneralMessage;

public class InputView {
    public static String askCarNames() {
        OutputView.printGeneralMessage(GeneralMessage.ASK_CAR_NAMES);
        return Console.readLine();
    }
}
