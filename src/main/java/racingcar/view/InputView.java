package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.MessageConstants;

public class InputView {

    public static String[] inputCarNames() {
        System.out.println(MessageConstants.INPUT_CAR_NAMES);
        String inputCarNames = Console.readLine();
        return inputCarNames.split(",");
    }

    public static String inputTryCount() {
        System.out.println(MessageConstants.INPUT_TRY_COUNT);
        return Console.readLine();
    }
}