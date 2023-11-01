package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.Messages;

public class InputView {
    public static String inputNames() {
        System.out.println(Messages.INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public static String inputNumber() {
        System.out.println(Messages.INPUT_COUNT_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
