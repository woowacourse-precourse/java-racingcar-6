package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Constants;

public class InputView {
    public static String inputCarNames() {
        System.out.println(Constants.INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public static String inputRound() {
        System.out.println(Constants.INPUT_ROUND_MESSAGE);
        return Console.readLine();
    }
}
