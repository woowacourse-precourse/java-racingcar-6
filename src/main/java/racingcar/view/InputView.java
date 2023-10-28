package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Messages;

public class InputView {
    public static String inputCarNames() {
        System.out.println(Messages.INPUT_CAR_NAMES.getMessage());
        return Console.readLine();
    }
}
