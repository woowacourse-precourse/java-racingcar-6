package racingcar.view;

import static racingcar.utils.ViewMessages.INPUT_CAR_NAMES;
import static racingcar.utils.ViewMessages.INPUT_REPEAT_COUNT;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.IntegerConvertor;

public class InputView {

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        return Console.readLine();
    }
}
