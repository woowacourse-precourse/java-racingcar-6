package racingcar.view;

import static racingcar.constant.Message.INPUT_CAR_NAME_MSG;
import static racingcar.constant.Message.INPUT_COUNT_TRY_MSG;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MSG);
        return Console.readLine();
    }

    public static String inputTryNumber() {
        System.out.println(INPUT_COUNT_TRY_MSG);
        return Console.readLine();
    }
}
