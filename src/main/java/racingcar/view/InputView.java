package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.enums.InputMessage;

public class InputView {
    public static String inputCarName() {
        System.out.println(InputMessage.NAME_OF_THE_CAR.getMessage());

        return Console.readLine();
    }

    public static String inputAttemptsNumber() {
        System.out.println(InputMessage.NUMBER_OF_ATTEMPTS.getMessage());

        return Console.readLine();
    }
}
