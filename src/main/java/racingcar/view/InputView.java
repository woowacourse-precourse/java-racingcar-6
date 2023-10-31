package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.GameConstants;

public class InputView {
    public static String inputName() {
        System.out.println(GameConstants.INPUT_NAMES);
        return Console.readLine();
    }

    public static String inputTryNum() {
        System.out.println(GameConstants.INPUT_TRY_NUMS);
        return Console.readLine();
    }
}

