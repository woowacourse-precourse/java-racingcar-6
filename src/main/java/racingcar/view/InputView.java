package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Constant;

public class InputView {
    public static String inputCarNames() {
        System.out.println(Constant.INPUT_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public static String inputRoundCount() {
        System.out.println(Constant.INPUT_RACING_ROUND_MESSAGE);
        return Console.readLine();
    }

}