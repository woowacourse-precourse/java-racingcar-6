package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constant.StringConstant.INPUT_ATTEMPT_NUMBER_MESSAGE;
import static racingcar.constant.StringConstant.INPUT_CAR_NAMES_MESSAGE;

public class InputView {
    public String inputNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public String inputAttemptNumber() {
        System.out.println(INPUT_ATTEMPT_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
